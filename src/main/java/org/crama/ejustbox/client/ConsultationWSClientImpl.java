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

import be.fgov.ejustice.ejustbox.consultation.protocol.v1.DeleteMessageRequestType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.DeleteMessageResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetBoxInfoRequestType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetBoxInfoResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetFullMessageResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetHistoryResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetMessageAcknowledgmentsStatusRequestType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetMessageAcknowledgmentsStatusResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetMessageListResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetMessagesListRequestType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.MessageRequestType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.MoveMessageRequestType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.MoveMessageResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.ObjectFactory;
import be.fgov.ejustice.ejustbox.core.v1.ActorType;
import be.fgov.ejustice.ejustbox.core.v1.CustomMetaType;
import be.fgov.ejustice.errors.service.v1.SystemErrorType;

public class ConsultationWSClientImpl extends WebServiceGatewaySupport implements ConsultationWSClient {
	
	private static final ObjectFactory CONSULTATION_OBJECT_FACTORY = new ObjectFactory();
	
	private static final Logger log = LoggerFactory.getLogger(ConsultationWSClientImpl.class);
	
	@Value("${ejustbox.consultation.service.url}")
	private String consultationServiceUrl;
	
	@SuppressWarnings("unchecked")
	public GetBoxInfoResponseType getBoxInfo(ActorType actor) throws EJustBoxClientException, XmlMappingException, IOException {

		log.info("Requesting get box info for actor: " + actor);
		
		
		GetBoxInfoRequestType request = CONSULTATION_OBJECT_FACTORY.createGetBoxInfoRequestType();
		request.setActor(actor);

		JAXBElement<GetBoxInfoRequestType> requestCall = CONSULTATION_OBJECT_FACTORY.createGetBoxInfoRequest(request);
		
		JAXBElement<GetBoxInfoResponseType> response = null;
		
		try {
		
			response = (JAXBElement<GetBoxInfoResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(consultationServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		
		log.info("getBoxInfoResponse: " + response.getValue());	
		
		
		return response.getValue();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public GetMessageListResponseType getMessageList(ActorType actor, String source, int startIndex, int endIndex, List<CustomMetaType> metaList) 
			throws XmlMappingException, IOException, EJustBoxClientException {

		log.info("Requesting get message list for actor: " + actor + "/n source: " + source + ", start index: " + startIndex + ", endIndex: " + endIndex);
		
		GetMessagesListRequestType request = CONSULTATION_OBJECT_FACTORY.createGetMessagesListRequestType();
		request.setActor(actor);
		request.setSource(source);
		request.setStartIndex(startIndex);
		request.setEndIndex(endIndex);
		
		JAXBElement<GetMessagesListRequestType> requestCall = CONSULTATION_OBJECT_FACTORY.createGetMessagesListRequest(request);
		
		JAXBElement<GetMessageListResponseType> response = null;
		
		try {
		
			response = (JAXBElement<GetMessageListResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(consultationServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		
		log.info("getMessagesListResponse: " + response.getValue());	
		
		
		return response.getValue();
		
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public GetFullMessageResponseType getFullMessage(ActorType actor, String source, String messageId)
			throws EJustBoxClientException, XmlMappingException, IOException {
		
		log.info("Requesting get full message for actor: " + actor + "/n source: " + source + ", message id: " + messageId);
		
		MessageRequestType request = CONSULTATION_OBJECT_FACTORY.createMessageRequestType();
		request.setActor(actor);
		request.setSource(source);
		request.setMessageId(messageId);
		
		JAXBElement<MessageRequestType> requestCall = CONSULTATION_OBJECT_FACTORY.createGetFullMessageRequest(request);
		
		JAXBElement<GetFullMessageResponseType> response = null;
		
		try {
		
			response = (JAXBElement<GetFullMessageResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(consultationServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		
		log.info("getFullMessagesResponse: " + response.getValue());	
		
		
		return response.getValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public MoveMessageResponseType moveMessages(ActorType actor, String source, String destination,
			List<String> messageId) throws EJustBoxClientException, XmlMappingException, IOException {
		
		log.info("Requesting move message for actor: " + actor + "/n source: " + source + ", messages: " + messageId);
		
		MoveMessageRequestType request = CONSULTATION_OBJECT_FACTORY.createMoveMessageRequestType();
		request.setActor(actor);
		request.setSource(source);
		request.setDestination(destination);
		for (String id: messageId) {
			request.getMessageId().add(id);
		}
		
		JAXBElement<MoveMessageRequestType> requestCall = CONSULTATION_OBJECT_FACTORY.createMoveMessageRequest(request);
		
		JAXBElement<MoveMessageResponseType> response = null;
		
		try {
		
			response = (JAXBElement<MoveMessageResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(consultationServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		log.info("getMoveMessagesResponse: " + response.getValue());	
			
		return response.getValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public DeleteMessageResponseType deleteMessages(ActorType actor, String source, List<String> messageId) throws EJustBoxClientException, XmlMappingException, IOException {
		
		log.info("Requesting delete message for actor: " + actor + "/n source: " + source + ", messages: " + messageId);
		
		DeleteMessageRequestType request = CONSULTATION_OBJECT_FACTORY.createDeleteMessageRequestType();
		request.setActor(actor);
		request.setSource(source);
		for (String id: messageId) {
			request.getMessageId().add(id);
		}
		JAXBElement<DeleteMessageRequestType> requestCall = CONSULTATION_OBJECT_FACTORY.createDeleteMessageRequest(request);
		
		JAXBElement<DeleteMessageResponseType> response = null;
		
		try {
		
			response = (JAXBElement<DeleteMessageResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(consultationServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		log.info("getDeleteMessagesResponse: " + response.getValue());	
			
		return response.getValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public GetHistoryResponseType getHistory(ActorType actor, String source, String messageId)
			throws EJustBoxClientException, XmlMappingException, IOException {
		
		log.info("Requesting get history for actor: " + actor + "/n source: " + source + ", message: " + messageId);
		
		MessageRequestType request = CONSULTATION_OBJECT_FACTORY.createMessageRequestType();
		request.setActor(actor);
		request.setSource(source);
		request.setMessageId(messageId);
		
		JAXBElement<MessageRequestType> requestCall = CONSULTATION_OBJECT_FACTORY.createGetHistoryRequest(request);
		
		JAXBElement<GetHistoryResponseType> response = null;
		
		try {
		
			response = (JAXBElement<GetHistoryResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(consultationServiceUrl, requestCall);
		
		}
		catch(SoapFaultClientException ex) {
			
			processFailure(ex);
			
		}

		log.info("getHistoryResponse: " + response.getValue());	
			
		return response.getValue();
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public GetMessageAcknowledgmentsStatusResponseType getMessageAcknowlegments(ActorType actor, String messageId,
			Integer startIndex, Integer endIndex) throws EJustBoxClientException, XmlMappingException, IOException {
		
		log.info("Requesting get message acknowlegments for actor: " + ", message: " + messageId + ", startIndex: " + startIndex + ", endIndex: " + endIndex);
		
		GetMessageAcknowledgmentsStatusRequestType request = CONSULTATION_OBJECT_FACTORY.createGetMessageAcknowledgmentsStatusRequestType();
		request.setActor(actor);
		request.setMessageId(messageId);
		request.setStartIndex(startIndex);
		request.setEndIndex(endIndex);
		
		JAXBElement<GetMessageAcknowledgmentsStatusRequestType> requestCall = CONSULTATION_OBJECT_FACTORY.createGetMessageAcknowledgmentsStatusRequest(request);
		
		JAXBElement<GetMessageAcknowledgmentsStatusResponseType> response = null;
		
		try {
		
			response = (JAXBElement<GetMessageAcknowledgmentsStatusResponseType>) getWebServiceTemplate()
	           .marshalSendAndReceive(consultationServiceUrl, requestCall);
		
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
