package org.crama.ejustbox.client;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.crama.ejustbox.configuration.EJustBoxConfiguration;
import org.crama.ejustbox.error.EJustBoxClientException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import be.fgov.ejustice.ejustbox.consultation.protocol.v1.DeleteMessageResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetBoxInfoResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetFullMessageResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetHistoryResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetMessageAcknowledgmentsStatusResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetMessageListResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.MoveMessageResponseType;
import be.fgov.ejustice.ejustbox.core.v1.ActorType;
import be.fgov.ejustice.ejustbox.core.v1.ObjectFactory;
import be.fgov.ejustice.errors.service.v1.SystemErrorType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=EJustBoxConfiguration.class)
@SpringBootTest
public class ConsultationWSClientTest {
	 
	@Autowired
	private ConsultationWSClient mockConsultationClient;
	
	private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
	
	private static final String WS_URL = "http://localhost:8088/mockConsultationService";
	
	//REQUESTS
	private static final String ACTOR_ID_SUCCESS = "121000000000012";
	private static final String ACTOR_ID_ERROR = "121000000000019";
	private static final String ACTOR_TYPE = "jjjjj";
	private static final String ACTOR_QUALIYY = "MBS";
	private static final String ACTOR_NAME = "Staatsblad";
	
	private static final String SOURCE = "INBOX"; 
	private static final int START_INDEX = 1;
	private static final int END_INDEX = 100;
	private static final int START_INDEX_ERROR_1 = 100;
	private static final int END_INDEX_ERROR_1 = 1;
	private static final int START_INDEX_ERROR_2 = 1;
	private static final int END_INDEX_ERROR_2 = 102;
	
	private static final String MESSAGE_ID = "1000000000265";
	private static final String MESSAGE_ID_INVALID = "invalid";
	private static final String MESSAGE_SOURCE_INVALID = "invalid";
	
	private static final String MOVE_MESSAGE_SOURCE = "BININBOX";
	private static final String MOVE_MESSAGE_DEST = "INBOX";
	private static final String MOVE_MESSAGE_SOURCE_ERROR = "SANDBOX";
	private static final String MOVE_MESSAGE_DEST_ERROR = "INBOX";
	private static final String MOVE_MESSAGE_ID_1 = "9Y0002LKM3006";
	private static final String MOVE_MESSAGE_ID_2 = "9Y0002LKM3007";
	
	private static final String MESSAGE_HISTORY_ID_REQUEST = "9Y0002LKM3006";
	
	//RESPONSES
	private static final String SUCCESS_MESSAGE = "SUCCESS";
	private static final String SUCCESS_CODE = "100";
	private static final Integer NBR_MESSAGES_IN_STANDBY = 0;
	private static final Integer NBR_UNREAD_MESSAGES = 5;
	private static final Long CURRENT_SIZE = 8911747l;
	private static final Long MAX_SIZE = 10485760l;
	
	private static final String GET_BOX_INFO_ERROR_CODE = "908";
	private static final String GET_BOX_INFO_ERROR_MESSAGE = "The Actor ID is invalid for the given type.";
	private static final String ERROR_CONTACT = "ejusticeDev@ejustice.fgov.be";
	
	private static final int MESSAGES_NUMBER = 3;
	private static final String MESSAGE_ID_1 = "100";
	private static final String MESSAGE_ID_2 = "101";
	private static final String MESSAGE_ID_3 = "102";
	private static final String SENDER_NAME_1 = "Ricky";
	private static final String SENDER_NAME_2 = "Martin";
	private static final String SENDER_NAME_3 = "Solomon";
	
	private static final String GET_MESSAGE_LIST_ERROR_CODE_1 = "807";
	private static final String GET_MESSAGE_LIST_ERROR_CODE_2 = "808";
	private static final String GET_MESSAGE_LIST_ERROR_MESSAGE_1 = "EndIndex must be larger or equal to StartIndex; please correct StartIndex and EndIndex.";
	private static final String GET_MESSAGE_LIST_ERROR_MESSAGE_2 = "A maximum of 100 messages can be returned by request; please correct StartIndex and EndIndex.";
	
	private static final String MESSAGE_TITLE = "Full Message Title";
	private static final String MESSAGE_ID_ERROR_CODE = "806";
	private static final String MESSAGE_ID_ERROR_MESSAGE = "The specified MessageID is invalid; please verify that the Source and the MessageID are correct and that you can access it.";
	
	private static final String MOVE_MESSAGE_ERROR_CODE_1 = "812";
	private static final String MOVE_MESSAGE_ERROR_MESSAGE_1 = "You can not move a message from your Inbox to your Sentbox (even via recycle bin) and vice versa.";
	private static final String MOVE_MESSAGE_ERROR_CODE_2 = "813";
	private static final String MOVE_MESSAGE_ERROR_MESSAGE_2 = "Not all messages were moved successfully. "
			+ "Please verify for each message that the Source and the MessageID are correct. "
			+ "Also pay attention that a message in the recycle bin which was moved from the Inbox cannot be restored back to the Sentbox and vice versa.";
	
	private static final String DELETE_MESSAGE_ERROR_CODE = "815";
	private static final String DELETE_MESSAGE_ERROR_MESSAGE = "Not all messages were deleted successfully. Please verify for each message that the Source and MessageId are correct.";
	
	private static final String MESSAGE_HISTORY_ID_RESPONSE = "9Y0002LKM3007";
	private static final int MESSAGE_HISTORY_RESPONSE_SIZE = 1;
	
	private static final String MESSAGE_ACKNOWLEGMENTS_RECIPIENT_ID_1 = "99999999964";
	private static final String MESSAGE_ACKNOWLEGMENTS_RECIPIENT_ID_2 = "99999999965";
	private static final int MESSAGE_ACKNOWLEGMENTS_RECIPIENTS_NUM = 2;
	private static final String MESSAGE_ACKNOWLEGMENTS_ERROR_CODE = "809";
	private static final String MESSAGE_ACKNOWLEGMENTS_ERROR_MESSAGE = "The specified MessageID is invalid; please verify that the MessageID is correct and that you are the sender.";
	
	@Test
    public void testGetBoxInfo_Success() throws XmlMappingException, EJustBoxClientException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		GetBoxInfoResponseType response = mockConsultationClient.getBoxInfo(actor);
		
		assertTrue(response.getStatus().getStatusMessage().equals(SUCCESS_MESSAGE));
		assertTrue(response.getNbrMessagesInStandBy().equals(NBR_MESSAGES_IN_STANDBY));
		assertTrue(response.getNbrUnreadMessages().equals(NBR_UNREAD_MESSAGES));
		assertTrue(response.getCurrentSize().equals(CURRENT_SIZE));
		assertTrue(response.getMaxSize().equals(MAX_SIZE));
		
    }
	
	@Test
    public void testGetBoxInfo_Error() throws XmlMappingException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_ERROR);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		GetBoxInfoResponseType response = null;
		try {
			response = mockConsultationClient.getBoxInfo(actor);
			
		}
		catch (EJustBoxClientException ex) {
			
			SystemErrorType systemError = ex.getSystemError();
			
			assertTrue(systemError.getCode().equals(GET_BOX_INFO_ERROR_CODE));
			assertTrue(systemError.getMessage().get(0).getValue().equals(GET_BOX_INFO_ERROR_MESSAGE));
			assertTrue(systemError.getContact().equals(ERROR_CONTACT));
			
		}
		assertNull(response);
		
    }
	
	@Test
    public void testGetMessageList_Success() throws XmlMappingException, EJustBoxClientException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		GetMessageListResponseType response = mockConsultationClient.getMessageList(actor, SOURCE, START_INDEX, END_INDEX);
		
		assertTrue(response.getStatus().getStatusMessage().equals(SUCCESS_MESSAGE));
		assertTrue(response.getMessage().size() == MESSAGES_NUMBER);
		assertTrue(response.getMessage().get(0).getMessageId().equals(MESSAGE_ID_1));
		assertTrue(response.getMessage().get(1).getMessageId().equals(MESSAGE_ID_2));
		assertTrue(response.getMessage().get(2).getMessageId().equals(MESSAGE_ID_3));
		assertTrue(response.getMessage().get(0).getSender().getName().equals(SENDER_NAME_1));
		assertTrue(response.getMessage().get(1).getSender().getName().equals(SENDER_NAME_2));
		assertTrue(response.getMessage().get(2).getSender().getName().equals(SENDER_NAME_3));
		
    }
	
	@Test
    public void testGetMessageList_Error_EndIndexGreaterThanStartIndex() throws XmlMappingException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		GetMessageListResponseType response = null;
		try {
			response = mockConsultationClient.getMessageList(actor, SOURCE, START_INDEX_ERROR_1, END_INDEX_ERROR_1);
			
		}
		catch (EJustBoxClientException ex) {
			
			SystemErrorType systemError = ex.getSystemError();
			
			assertTrue(systemError.getCode().equals(GET_MESSAGE_LIST_ERROR_CODE_1));
			assertTrue(systemError.getMessage().get(0).getValue().equals(GET_MESSAGE_LIST_ERROR_MESSAGE_1));
			assertTrue(systemError.getContact().equals(ERROR_CONTACT));
			
		}
		assertNull(response);
		
    }
	
	@Test
    public void testGetMessageList_Error_MaxMessageNumViolation() throws XmlMappingException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		GetMessageListResponseType response = null;
		try {
			response = mockConsultationClient.getMessageList(actor, SOURCE, START_INDEX_ERROR_2, END_INDEX_ERROR_2);
			
		}
		catch (EJustBoxClientException ex) {
			
			SystemErrorType systemError = ex.getSystemError();
			
			assertTrue(systemError.getCode().equals(GET_MESSAGE_LIST_ERROR_CODE_2));
			assertTrue(systemError.getMessage().get(0).getValue().equals(GET_MESSAGE_LIST_ERROR_MESSAGE_2));
			assertTrue(systemError.getContact().equals(ERROR_CONTACT));
			
		}
		assertNull(response);
		
    }
	
	@Test
    public void testGetFullMessage_Success() throws XmlMappingException, EJustBoxClientException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		GetFullMessageResponseType response = mockConsultationClient.getFullMessage(actor, SOURCE, MESSAGE_ID);
		
		assertTrue(response.getStatus().getStatusMessage().equals(SUCCESS_MESSAGE));
		assertTrue(response.getMessage().getMessageId().equals(MESSAGE_ID));
		assertTrue(response.getMessage().getContentContext().getContent().getDocument().getTitle().equals(MESSAGE_TITLE));
		
		
    }
	
	@Test
    public void testGetFullMessage_Error_MessageIdIsInvalid() throws XmlMappingException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		GetFullMessageResponseType response = null;
		try {
			response = mockConsultationClient.getFullMessage(actor, SOURCE, MESSAGE_ID_INVALID);
			
		}
		catch (EJustBoxClientException ex) {
			
			SystemErrorType systemError = ex.getSystemError();
			
			assertTrue(systemError.getCode().equals(MESSAGE_ID_ERROR_CODE));
			assertTrue(systemError.getMessage().get(0).getValue().equals(MESSAGE_ID_ERROR_MESSAGE));
			assertTrue(systemError.getContact().equals(ERROR_CONTACT));
			
		}
		assertNull(response);
		
    }
	
	
	@Test
    public void testMoveMessage_Success() throws XmlMappingException, EJustBoxClientException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		MoveMessageResponseType response = mockConsultationClient.moveMessages(actor, MOVE_MESSAGE_SOURCE, MOVE_MESSAGE_DEST, 
				new ArrayList<String>(Arrays.asList(MOVE_MESSAGE_ID_1, MOVE_MESSAGE_ID_2)));
		
		assertTrue(response.getStatus().getStatusMessage().equals(SUCCESS_MESSAGE));
		assertTrue(response.getStatus().getStatusCode().getValue().equals(SUCCESS_CODE));
		
    }
	
	@Test
    public void testMoveMessage_Error_MessageIdIsInvalid() throws XmlMappingException, IOException, EJustBoxClientException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		MoveMessageResponseType response = mockConsultationClient.moveMessages(actor, MOVE_MESSAGE_SOURCE, MOVE_MESSAGE_DEST, 
					new ArrayList<String>(Arrays.asList(MESSAGE_ID_INVALID, MOVE_MESSAGE_ID_2)));
		
		
		assertTrue(response.getStatus().getStatusMessage().equals(MOVE_MESSAGE_ERROR_MESSAGE_2));
		assertTrue(response.getStatus().getStatusCode().getValue().equals(MOVE_MESSAGE_ERROR_CODE_2));
		assertTrue(response.getMessageId().get(0).equals(MESSAGE_ID_INVALID));
    }
	
	@Test
    public void testGetFullMessage_Error_SourceDestInvalid() throws XmlMappingException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		MoveMessageResponseType response = null;
		try {
			
			response = mockConsultationClient.moveMessages(actor, MOVE_MESSAGE_SOURCE_ERROR, MOVE_MESSAGE_DEST_ERROR, 
					new ArrayList<String>(Arrays.asList(MOVE_MESSAGE_ID_1, MOVE_MESSAGE_ID_2)));
			
		}
		catch (EJustBoxClientException ex) {
			
			SystemErrorType systemError = ex.getSystemError();
			
			assertTrue(systemError.getCode().equals(MOVE_MESSAGE_ERROR_CODE_1));
			assertTrue(systemError.getMessage().get(0).getValue().equals(MOVE_MESSAGE_ERROR_MESSAGE_1));
			assertTrue(systemError.getContact().equals(ERROR_CONTACT));
			
		}
		
		assertNull(response);
		
    }
	
	
	@Test
    public void testDeleteMessage_Success() throws XmlMappingException, EJustBoxClientException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		DeleteMessageResponseType response = mockConsultationClient.deleteMessages(actor, SOURCE, 
				new ArrayList<String>(Arrays.asList(MOVE_MESSAGE_ID_1, MOVE_MESSAGE_ID_2)));
		
		assertTrue(response.getStatus().getStatusMessage().equals(SUCCESS_MESSAGE));
		assertTrue(response.getStatus().getStatusCode().getValue().equals(SUCCESS_CODE));
		
    }
	
	@Test
    public void testDeleteMessage_Error_MessageIdIsInvalid() throws XmlMappingException, IOException, EJustBoxClientException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		DeleteMessageResponseType response = mockConsultationClient.deleteMessages(actor, SOURCE, 
					new ArrayList<String>(Arrays.asList(MESSAGE_ID_INVALID, MOVE_MESSAGE_ID_2)));
		
		
		assertTrue(response.getStatus().getStatusMessage().equals(DELETE_MESSAGE_ERROR_MESSAGE));
		assertTrue(response.getStatus().getStatusCode().getValue().equals(DELETE_MESSAGE_ERROR_CODE));
		assertTrue(response.getMessageId().get(0).equals(MESSAGE_ID_INVALID));
    }
	
	@Test
    public void testGetHistory_Success() throws XmlMappingException, EJustBoxClientException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		GetHistoryResponseType response = mockConsultationClient.getHistory(actor, SOURCE, MESSAGE_HISTORY_ID_REQUEST);
		
		assertTrue(response.getStatus().getStatusCode().getValue().equals(SUCCESS_CODE));
		assertTrue(response.getStatus().getStatusMessage().equals(SUCCESS_MESSAGE));
		assertTrue(response.getMessageId().size() == MESSAGE_HISTORY_RESPONSE_SIZE);
		assertTrue(response.getMessageId().get(0).equals(MESSAGE_HISTORY_ID_RESPONSE));
		
    }
	
	@Test
    public void testGetHistory_Error() throws XmlMappingException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		GetHistoryResponseType response = null;
		try {
			response = mockConsultationClient.getHistory(actor, MESSAGE_SOURCE_INVALID, MESSAGE_HISTORY_ID_REQUEST);
			
		}
		catch (EJustBoxClientException ex) {
			
			SystemErrorType systemError = ex.getSystemError();
			
			assertTrue(systemError.getCode().equals(MESSAGE_ID_ERROR_CODE));
			assertTrue(systemError.getMessage().get(0).getValue().equals(MESSAGE_ID_ERROR_MESSAGE));
			assertTrue(systemError.getContact().equals(ERROR_CONTACT));
			
		}
		
		assertNull(response);
		
    }
	
	@Test
    public void testGetMessageAcknowlegmentsStatus_Success() throws XmlMappingException, EJustBoxClientException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		GetMessageAcknowledgmentsStatusResponseType response = mockConsultationClient.getMessageAcknowlegments(actor, MESSAGE_HISTORY_ID_REQUEST, null, null);
		
		assertTrue(response.getStatus().getStatusCode().getValue().equals(SUCCESS_CODE));
		assertTrue(response.getStatus().getStatusMessage().equals(SUCCESS_MESSAGE));
		assertTrue(response.getAcknowledgmentsStatus().getRow().size() == MESSAGE_ACKNOWLEGMENTS_RECIPIENTS_NUM);
		assertTrue(response.getAcknowledgmentsStatus().getRow().get(0).getRecipient().getId().equals(MESSAGE_ACKNOWLEGMENTS_RECIPIENT_ID_1));
		assertTrue(response.getAcknowledgmentsStatus().getRow().get(1).getRecipient().getId().equals(MESSAGE_ACKNOWLEGMENTS_RECIPIENT_ID_2));
		
    }
	
	@Test
    public void testGetMessageAcknowlegmentsStatus_Error() throws XmlMappingException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		ReflectionTestUtils.setField(mockConsultationClient, "consultationServiceUrl", WS_URL);
		
		GetMessageAcknowledgmentsStatusResponseType response = null;
		try {
			response = mockConsultationClient.getMessageAcknowlegments(actor, MESSAGE_SOURCE_INVALID, null, null);
			
		}
		catch (EJustBoxClientException ex) {
			
			SystemErrorType systemError = ex.getSystemError();
			
			assertTrue(systemError.getCode().equals(MESSAGE_ACKNOWLEGMENTS_ERROR_CODE));
			assertTrue(systemError.getMessage().get(0).getValue().equals(MESSAGE_ACKNOWLEGMENTS_ERROR_MESSAGE));
			assertTrue(systemError.getContact().equals(ERROR_CONTACT));
			
		}
		
		assertNull(response);
		
    }
	
	
	
	
}
