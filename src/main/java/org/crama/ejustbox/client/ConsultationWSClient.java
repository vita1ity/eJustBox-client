package org.crama.ejustbox.client;

import java.io.IOException;
import java.util.List;

import org.crama.ejustbox.error.EJustBoxClientException;
import org.springframework.oxm.XmlMappingException;

import be.fgov.ejustice.ejustbox.consultation.protocol.v1.DeleteMessageResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetBoxInfoResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetFullMessageResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetHistoryResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetMessageAcknowledgmentsStatusResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetMessageListResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.MoveMessageResponseType;
import be.fgov.ejustice.ejustbox.core.v1.ActorType;
import be.fgov.ejustice.ejustbox.core.v1.CustomMetaType;

public interface ConsultationWSClient {

	GetBoxInfoResponseType getBoxInfo(ActorType actor) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	GetMessageListResponseType getMessageList(ActorType actor, String source, int startIndex, int endIndex, List<CustomMetaType> metaList) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	GetFullMessageResponseType getFullMessage(ActorType actor, String source, String messageId) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	MoveMessageResponseType moveMessages(ActorType actor, String source, String destination, List<String> messageId) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	DeleteMessageResponseType deleteMessages(ActorType actor, String source, List<String> messageId) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	GetHistoryResponseType getHistory(ActorType actor, String source, String messageId) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	GetMessageAcknowledgmentsStatusResponseType getMessageAcknowlegments(ActorType actor, String messageId, Integer startIndex, Integer endIndex) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	
}
