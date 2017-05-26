package org.crama.ejustbox.client;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.crama.ejustbox.error.EJustBoxClientException;
import org.crama.ejustbox.model.consultation.ActorType2;
import org.crama.ejustbox.model.consultation.DeleteMessageRequestType;
import org.crama.ejustbox.model.consultation.DeleteMessageResponseType;
import org.crama.ejustbox.model.consultation.GetBoxInfoRequestType;
import org.crama.ejustbox.model.consultation.GetBoxInfoResponseType;
import org.crama.ejustbox.model.consultation.GetFullMessageResponseType;
import org.crama.ejustbox.model.consultation.GetHistoryResponseType;
import org.crama.ejustbox.model.consultation.GetMessageAcknowledgmentsStatusRequestType;
import org.crama.ejustbox.model.consultation.GetMessageAcknowledgmentsStatusResponseType;
import org.crama.ejustbox.model.consultation.GetMessageListResponseType;
import org.crama.ejustbox.model.consultation.GetMessagesListRequestType;
import org.crama.ejustbox.model.consultation.MessageRequestType;
import org.crama.ejustbox.model.consultation.MoveMessageRequestType;
import org.crama.ejustbox.model.consultation.MoveMessageResponseType;
import org.crama.ejustbox.model.consultation.ObjectFactory;
import org.crama.ejustbox.model.consultation.SystemErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.XmlMappingException;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapFaultDetailElement;
import org.springframework.ws.soap.client.SoapFaultClientException;

public class ConsultationWSClientImpl extends WebServiceGatewaySupport implements ConsultationWSClient {
	
	private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
	
	private static final Logger log = LoggerFactory.getLogger(ConsultationWSClientImpl.class);
	
	@Value("${ejustbox.service.url}")
	private String webServiceUrl;
	
	@SuppressWarnings("unchecked")
	public GetBoxInfoResponseType getBoxInfo(ActorType2 actor) throws EJustBoxClientException, XmlMappingException, IOException {

		log.info("Requesting get box info for actor: " + actor);
		
		GetBoxInfoRequestType request = OBJECT_FACTORY.createGetBoxInfoRequestType(actor, false);

		JAXBElement<GetBoxInfoRequestType> requestCall = OBJECT_FACTORY.createGetBoxInfoRequest(request);
		
		JAXBElement<GetBoxInfoResponseType> response = null;
		
		try {
		
			response = (JAXBElement<GetBoxInfoResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(webServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		
		log.info("getBoxInfoResponse: " + response.getValue());	
		
		
		return response.getValue();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public GetMessageListResponseType getMessageList(ActorType2 actor, String source, int startIndex, int endIndex) 
			throws XmlMappingException, IOException, EJustBoxClientException {

		log.info("Requesting get message list for actor: " + actor + "/n source: " + source + ", start index: " + startIndex + ", endIndex: " + endIndex);
		
		GetMessagesListRequestType request = OBJECT_FACTORY.createGetMessagesListRequestType();
		request.setActor(actor);
		request.setSource(source);
		request.setStartIndex(startIndex);
		request.setEndIndex(endIndex);
		
		JAXBElement<GetMessagesListRequestType> requestCall = OBJECT_FACTORY.createGetMessagesListRequest(request);
		
		JAXBElement<GetMessageListResponseType> response = null;
		
		try {
		
			response = (JAXBElement<GetMessageListResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(webServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		
		log.info("getMessagesListResponse: " + response.getValue());	
		
		
		return response.getValue();
		
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public GetFullMessageResponseType getFullMessage(ActorType2 actor, String source, String messageId)
			throws EJustBoxClientException, XmlMappingException, IOException {
		
		log.info("Requesting get full message for actor: " + actor + "/n source: " + source + ", message id: " + messageId);
		
		MessageRequestType request = OBJECT_FACTORY.createMessageRequestType();
		request.setActor(actor);
		request.setSource(source);
		request.setMessageId(messageId);
		
		JAXBElement<MessageRequestType> requestCall = OBJECT_FACTORY.createGetFullMessageRequest(request);
		
		JAXBElement<GetFullMessageResponseType> response = null;
		
		try {
		
			response = (JAXBElement<GetFullMessageResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(webServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		
		log.info("getFullMessagesResponse: " + response.getValue());	
		
		
		return response.getValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public MoveMessageResponseType moveMessages(ActorType2 actor, String source, String destination,
			List<String> messageId) throws EJustBoxClientException, XmlMappingException, IOException {
		
		log.info("Requesting move message for actor: " + actor + "/n source: " + source + ", messages: " + messageId);
		
		MoveMessageRequestType request = OBJECT_FACTORY.createMoveMessageRequestType();
		request.setActor(actor);
		request.setSource(source);
		request.setDestination(destination);
		request.setMessageId(messageId);
		
		JAXBElement<MoveMessageRequestType> requestCall = OBJECT_FACTORY.createMoveMessageRequest(request);
		
		JAXBElement<MoveMessageResponseType> response = null;
		
		try {
		
			response = (JAXBElement<MoveMessageResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(webServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		log.info("getMoveMessagesResponse: " + response.getValue());	
			
		return response.getValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public DeleteMessageResponseType deleteMessages(ActorType2 actor, String source, List<String> messageId) throws EJustBoxClientException, XmlMappingException, IOException {
		
		log.info("Requesting delete message for actor: " + actor + "/n source: " + source + ", messages: " + messageId);
		
		DeleteMessageRequestType request = OBJECT_FACTORY.createDeleteMessageRequestType();
		request.setActor(actor);
		request.setSource(source);
		request.setMessageId(messageId);
		
		JAXBElement<DeleteMessageRequestType> requestCall = OBJECT_FACTORY.createDeleteMessageRequest(request);
		
		JAXBElement<DeleteMessageResponseType> response = null;
		
		try {
		
			response = (JAXBElement<DeleteMessageResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(webServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		log.info("getDeleteMessagesResponse: " + response.getValue());	
			
		return response.getValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public GetHistoryResponseType getHistory(ActorType2 actor, String source, String messageId)
			throws EJustBoxClientException, XmlMappingException, IOException {
		
		log.info("Requesting get history for actor: " + actor + "/n source: " + source + ", message: " + messageId);
		
		MessageRequestType request = OBJECT_FACTORY.createMessageRequestType();
		request.setActor(actor);
		request.setSource(source);
		request.setMessageId(messageId);
		
		JAXBElement<MessageRequestType> requestCall = OBJECT_FACTORY.createGetHistoryRequest(request);
		
		JAXBElement<GetHistoryResponseType> response = null;
		
		try {
		
			response = (JAXBElement<GetHistoryResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(webServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		log.info("getHistoryResponse: " + response.getValue());	
			
		return response.getValue();
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public GetMessageAcknowledgmentsStatusResponseType getMessageAcknowlegments(ActorType2 actor, String messageId,
			Integer startIndex, Integer endIndex) throws EJustBoxClientException, XmlMappingException, IOException {
		
		log.info("Requesting get message acknowlegments for actor: " + ", message: " + messageId + ", startIndex: " + startIndex + ", endIndex: " + endIndex);
		
		GetMessageAcknowledgmentsStatusRequestType request = OBJECT_FACTORY.createGetMessageAcknowledgmentsStatusRequestType();
		request.setActor(actor);
		request.setMessageId(messageId);
		request.setStartIndex(startIndex);
		request.setEndIndex(endIndex);
		
		JAXBElement<GetMessageAcknowledgmentsStatusRequestType> requestCall = OBJECT_FACTORY.createGetMessageAcknowledgmentsStatusRequest(request);
		
		JAXBElement<GetMessageAcknowledgmentsStatusResponseType> response = null;
		
		try {
		
			response = (JAXBElement<GetMessageAcknowledgmentsStatusResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(webServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		log.info("getMessageAcknowlegmentsStatusResponse: " + response.getValue());	
			
		return response.getValue();
	}
	
	
	@SuppressWarnings("unchecked")
	private void processFailure(SoapFaultClientException ex) throws XmlMappingException, IOException, EJustBoxClientException {
		
		SoapFaultDetailElement fault = ex.getSoapFault().getFaultDetail().getDetailEntries().next();
		
		JAXBElement<SystemErrorType> systemError = (JAXBElement<SystemErrorType>) getWebServiceTemplate().getUnmarshaller().unmarshal(fault.getSource());
		
		log.error("SYSTEM ERROR: " + systemError.getValue());
		
		throw new EJustBoxClientException(systemError.getValue());
		
	}

	


	
}
