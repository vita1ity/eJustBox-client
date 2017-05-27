package org.crama.ejustbox.client;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.crama.ejustbox.error.EJustBoxClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.XmlMappingException;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapFaultDetailElement;
import org.springframework.ws.soap.client.SoapFaultClientException;

import be.fgov.ejustice.ejustbox.core.v1.ActorType;
import be.fgov.ejustice.ejustbox.core.v1.MetaType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.ContentContextType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.DestinationContextType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.ObjectFactory;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.PublicationMessageType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.SendMessageResponse;
import be.fgov.ejustice.errors.service.v1.SystemErrorType;

public class PublicationWSClientImpl extends WebServiceGatewaySupport implements PublicationWSClient {

	private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
	
	private static final Logger log = LoggerFactory.getLogger(PublicationWSClientImpl.class);
	
	@Value("${ejustbox.publication.service.url}")
	private String publicationServiceUrl;

	@Override
	public SendMessageResponse sendMessage(String publicationId, ActorType actor, List<DestinationContextType> destinationContext,
			ContentContextType contentContext, List<MetaType> metaList)
			throws EJustBoxClientException, XmlMappingException, IOException {

		log.info("Requesting send message for actor: " + actor + " destinationContext: " + destinationContext + ", "
				+ "contentContext: " + contentContext + ", publicationId: " + publicationId);
		
		PublicationMessageType request = OBJECT_FACTORY.createPublicationMessageType();
		request.setActor(actor);
		for (DestinationContextType context: destinationContext) {
			request.getDestinationContext().add(context);
		}
		request.setContentContext(contentContext);
		request.setPublicationId(publicationId);
		
		JAXBElement<PublicationMessageType> requestCall = OBJECT_FACTORY.createSendMessageRequest(request);
		
		SendMessageResponse response = null;
		
		try {
		
			response = (SendMessageResponse) getWebServiceTemplate()
	           .marshalSendAndReceive(publicationServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		log.info("SendMessagesResponse: " + response);	
			
		return response;
		
	}
	
	@SuppressWarnings("unchecked")
	private void processFailure(SoapFaultClientException ex) throws XmlMappingException, IOException, EJustBoxClientException {
		
		SoapFaultDetailElement fault = ex.getSoapFault().getFaultDetail().getDetailEntries().next();
		
		JAXBElement<SystemErrorType> systemError = (JAXBElement<SystemErrorType>) getWebServiceTemplate().getUnmarshaller().unmarshal(fault.getSource());
		
		log.error("SYSTEM ERROR: " + systemError.getValue());
		
		throw new EJustBoxClientException(systemError.getValue());
		
	}
	
	
}
