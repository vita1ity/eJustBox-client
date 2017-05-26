package org.crama.ejustbox.client;

import java.io.IOException;

import org.crama.ejustbox.error.EJustBoxClientException;
import org.crama.ejustbox.model.consultation.ActorType2;
import org.crama.ejustbox.model.consultation.GetBoxInfoResponseType;
import org.crama.ejustbox.model.consultation.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.XmlMappingException;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class PublicationWSClientImpl extends WebServiceGatewaySupport implements PublicationWSClient {

	private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
	
	private static final Logger log = LoggerFactory.getLogger(PublicationWSClientImpl.class);
	
	@Value("${ejustbox.service.url}")
	private String webServiceUrl;
	
	/*public ResponseType sendMessage(ActorType2 actor) 
			throws EJustBoxClientException, XmlMappingException, IOException {
		
		
		
	}*/
	
}
