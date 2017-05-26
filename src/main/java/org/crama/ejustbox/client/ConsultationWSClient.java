package org.crama.ejustbox.client;

import java.io.IOException;
import java.util.List;

import org.crama.ejustbox.error.EJustBoxClientException;
import org.crama.ejustbox.model.consultation.ActorType2;
import org.crama.ejustbox.model.consultation.DeleteMessageResponseType;
import org.crama.ejustbox.model.consultation.GetBoxInfoResponseType;
import org.crama.ejustbox.model.consultation.GetFullMessageResponseType;
import org.crama.ejustbox.model.consultation.GetHistoryResponseType;
import org.crama.ejustbox.model.consultation.GetMessageAcknowledgmentsStatusResponseType;
import org.crama.ejustbox.model.consultation.GetMessageListResponseType;
import org.crama.ejustbox.model.consultation.MoveMessageResponseType;
import org.springframework.oxm.XmlMappingException;

public interface ConsultationWSClient {

	GetBoxInfoResponseType getBoxInfo(ActorType2 actor) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	GetMessageListResponseType getMessageList(ActorType2 actor, String source, int startIndex, int endIndex) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	GetFullMessageResponseType getFullMessage(ActorType2 actor, String source, String messageId) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	MoveMessageResponseType moveMessages(ActorType2 actor, String source, String destination, List<String> messageId) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	DeleteMessageResponseType deleteMessages(ActorType2 actor, String source, List<String> messageId) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	GetHistoryResponseType getHistory(ActorType2 actor, String source, String messageId) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	GetMessageAcknowledgmentsStatusResponseType getMessageAcknowlegments(ActorType2 actor, String messageId, Integer startIndex, Integer endIndex) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
	
}
