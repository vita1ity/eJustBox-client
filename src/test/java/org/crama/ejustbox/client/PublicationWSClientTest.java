package org.crama.ejustbox.client;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.crama.ejustbox.configuration.EJustBoxClientConfiguration;
import org.crama.ejustbox.error.EJustBoxClientException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import be.fgov.ejustice.ejustbox.core.v1.ActorType;
import be.fgov.ejustice.ejustbox.core.v1.ObjectFactory;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.ContentContextType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.ContentSpecificationType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.DestinationContextType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.PublicationContentType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.PublicationDocumentType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.SendMessageResponse;
import be.fgov.ejustice.errors.service.v1.SystemErrorType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=EJustBoxClientConfiguration.class)
@SpringBootTest
public class PublicationWSClientTest {

	@Autowired
	private PublicationWSClient mockPublicationClient;
	
	private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
	private static final be.fgov.ejustice.ejustbox.publication.protocol.v1.ObjectFactory PUBLICATION_OBJECT_FACTORY = 
			new be.fgov.ejustice.ejustbox.publication.protocol.v1.ObjectFactory();
	
	private static final String WS_URL = "http://localhost:8088/mockPublicationService";
	
	//REQUEST
	private static final String ACTOR_ID_SUCCESS = "121000000000012";
	private static final String ACTOR_TYPE = "jjjjj";
	private static final String ACTOR_QUALIYY = "MBS";
	private static final String ACTOR_NAME = "Staatsblad";
	
	private static final String DESTINATION_ID_1 = "121000000000018";
	private static final String DESTINATION_TYPE_1 = "EBOXID";
	private static final String DESTINATION_QUALITY_1 = "MBS";
	
	private static final String DESTINATION_TYPE_INVALID = "invalid";
	private static final String DESTINATION_QUALITY_INVALID = "invalid";
	
	private static final String DESTINATION_ID_2 = "121000000000019";
	private static final String DESTINATION_TYPE_2 = "jjjjj";
	private static final String DESTINATION_QUALITY_2 = "MBS";
	
	private static final String DOC_TYPE = "Message Title";
	private static final String DOC_CONTENT = "Message content";
	
	private static final String CONTENT_TYPE = "DOCUMENT";
	
	private static final String PUBLICATION_ID = "1009927801393";
	
	
	//RESPONSE
	private static final String SUCCESS_MESSAGE = "SUCCESS";
	private static final String SUCCESS_CODE = "100";
	
	private static final String SEND_MESSAGE_ERROR_CODE = "805";
	private static final String SEND_MESSAGE_ERROR_MESSAGE = "The specified SubType is invalid; please verify that SubType is a subtype recognized by the system.";
	private static final String ERROR_CONTACT = "ejusticeDev@ejustice.fgov.be";
	
	@Test
    public void testSendMessage_Success() throws XmlMappingException, EJustBoxClientException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		DestinationContextType destinationContext1 = PUBLICATION_OBJECT_FACTORY.createDestinationContextType();
		destinationContext1.setId(DESTINATION_ID_1);
		destinationContext1.setType(DESTINATION_TYPE_1);
		destinationContext1.setQuality(DESTINATION_QUALITY_1);
		
		DestinationContextType destinationContext2 = PUBLICATION_OBJECT_FACTORY.createDestinationContextType();
		destinationContext2.setId(DESTINATION_ID_2);
		destinationContext2.setType(DESTINATION_TYPE_2);
		destinationContext2.setQuality(DESTINATION_QUALITY_2);
		
		List<DestinationContextType> destContext = new ArrayList<DestinationContextType>(Arrays.asList(destinationContext1, destinationContext2));
		
		ContentContextType contentContext = new ContentContextType();
		PublicationDocumentType docType = new PublicationDocumentType();
		docType.setTitle(DOC_TYPE);
		docType.setEncryptableContent(DOC_CONTENT.getBytes());
		PublicationContentType pubContType = new PublicationContentType();
		pubContType.setDocument(docType);
		ContentSpecificationType specType = new ContentSpecificationType();
		specType.setContentType(CONTENT_TYPE);
		
		contentContext.setContent(pubContType);
		contentContext.setContentSpecification(specType);
		
		ReflectionTestUtils.setField(mockPublicationClient, "publicationServiceUrl", WS_URL);
		
		SendMessageResponse response = mockPublicationClient.sendMessage(PUBLICATION_ID, actor, destContext, contentContext, null);
		
		assertTrue(response.getStatus().getStatusMessage().equals(SUCCESS_MESSAGE));
		assertTrue(response.getStatus().getStatusCode().getValue().equals(SUCCESS_CODE));
		assertTrue(response.getSentPublicationId().equals(PUBLICATION_ID));
		
    }
	
	@Test
    public void testGetBoxInfo_Error() throws XmlMappingException, IOException {
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(ACTOR_ID_SUCCESS);
		actor.setType(ACTOR_TYPE);
		actor.setQuality(ACTOR_QUALIYY);
		actor.setName(ACTOR_NAME);
		
		DestinationContextType destinationContext1 = PUBLICATION_OBJECT_FACTORY.createDestinationContextType();
		destinationContext1.setId(DESTINATION_ID_1);
		destinationContext1.setType(DESTINATION_TYPE_INVALID);
		destinationContext1.setQuality(DESTINATION_QUALITY_INVALID);
		
		List<DestinationContextType> destContext = new ArrayList<DestinationContextType>(Arrays.asList(destinationContext1));
		
		ContentContextType contentContext = new ContentContextType();
		PublicationDocumentType docType = new PublicationDocumentType();
		docType.setTitle(DOC_TYPE);
		docType.setEncryptableContent(DOC_CONTENT.getBytes());
		PublicationContentType pubContType = new PublicationContentType();
		pubContType.setDocument(docType);
		ContentSpecificationType specType = new ContentSpecificationType();
		specType.setContentType(CONTENT_TYPE);
		
		ReflectionTestUtils.setField(mockPublicationClient, "publicationServiceUrl", WS_URL);
		
		SendMessageResponse response = null;
		try {
			response = mockPublicationClient.sendMessage(PUBLICATION_ID, actor, destContext, contentContext, null);
			
		}
		catch (EJustBoxClientException ex) {
			
			SystemErrorType systemError = ex.getSystemError();
			
			assertTrue(systemError.getCode().equals(SEND_MESSAGE_ERROR_CODE));
			assertTrue(systemError.getMessage().get(0).getValue().equals(SEND_MESSAGE_ERROR_MESSAGE));
			assertTrue(systemError.getContact().equals(ERROR_CONTACT));
			
		}
		assertNull(response);
		
    }
	
}
