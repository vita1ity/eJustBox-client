package org.crama.ejustbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.crama.ejustbox.client.ConsultationWSClient;
import org.crama.ejustbox.client.PublicationWSClient;
import org.crama.ejustbox.error.EJustBoxClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.XmlMappingException;

import be.fgov.ejustice.ejustbox.consultation.protocol.v1.DeleteMessageResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetBoxInfoResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetFullMessageResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetHistoryResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetMessageAcknowledgmentsStatusResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.GetMessageListResponseType;
import be.fgov.ejustice.ejustbox.consultation.protocol.v1.MoveMessageResponseType;
import be.fgov.ejustice.ejustbox.core.v1.ObjectFactory;
import be.fgov.ejustice.ejustbox.core.v1.ActorType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.ContentContextType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.ContentSpecificationType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.DestinationContextType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.PublicationContentType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.PublicationDocumentType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.SendMessageResponse;

@SpringBootApplication
public class EJustBoxClientApplication implements CommandLineRunner {

	private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
	private static final be.fgov.ejustice.ejustbox.publication.protocol.v1.ObjectFactory PUBLICATION_OBJECT_FACTORY = 
			new be.fgov.ejustice.ejustbox.publication.protocol.v1.ObjectFactory();
	
	@Autowired
	private ConsultationWSClient consultationClient;
	
	@Autowired
	private PublicationWSClient publicationClient;
	
	@Value("${ejustbox.client.actor.id.default}")
	private String actorId;
	
	@Value("${ejustbox.client.actor.type.default}")
	private String actorType;
	
	@Value("${ejustbox.client.actor.quality.default}")
	private String actorQuality;
	
	@Value("${ejustbox.client.actor.name.default}")
	private String actorName;
	
	@Value("${ejustbox.client.source}")
	private String source;
	
	@Value("${ejustbox.client.destination}")
	private String destination;
	
	@Value("${ejustbox.client.startIndex}")
	private int startIndex;
	
	@Value("${ejustbox.client.endIndex}")
	private int endIndex;
	
	@Value("${ejustbox.client.messageId}")
	private String messageId;
	
	@Value("${ejustbox.client.messageId1}")
	private String messageId1;
	
	@Value("${ejustbox.client.messageId2}")
	private String messageId2;
	
	@Value("${ejustbox.publication.client.dest.id1}")
	private String destId1;
	
	@Value("${ejustbox.publication.client.dest.type1}")
	private String destType1;
	
	@Value("${ejustbox.publication.client.dest.quality1}")
	private String destQuality1;
	
	@Value("${ejustbox.publication.client.dest.id2}")
	private String destId2;
	
	@Value("${ejustbox.publication.client.dest.type2}")
	private String destType2;
	
	@Value("${ejustbox.publication.client.dest.quality2}")
	private String destQuality2;
	
	@Value("${ejustbox.publication.client.doc.title}")
	private String docTitle;
	
	@Value("${ejustbox.publication.client.doc.content}")
	private String docContent;
	
	@Value("${ejustbox.publication.client.content.type}")
	private String contentType;
	
	@Value("${ejustbox.publication.client.publication.id}")
	private String publicationId;
	
	
	private static final Logger log = LoggerFactory.getLogger(EJustBoxClientApplication.class);
	
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(EJustBoxClientApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.setWebEnvironment(false);
        app.run(args);
	
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		log.info("EJustBox Client running...");
		
		menu();
		
	
	}
	
	private void menu() throws XmlMappingException, IOException {
		
		while (true) {
			
			System.out.println("Choose method id that you want to test");
			
			System.out.println("1. Get Box Info");
			System.out.println("2. Get Messages List");
			System.out.println("3. Get Full Message");
			System.out.println("4. Move Message");
			System.out.println("5. Delete Message");
			System.out.println("6. Get Message History");
			System.out.println("7. Get Message Acknowlegments");
			System.out.println("8. Send Message");
			System.out.println("0. Exit");
			
			int option = sc.nextInt();
			
			switch (option) {
			case 1: 
				getBoxInfoRequest();
				break;
			case 2:
				getMessagesListRequest();
				break;
			case 3:
				getFullMessageRequest();
				break;
			case 4:
				moveMessageRequest();
				break;
			case 5:
				deleteMessageRequest();
				break;
			case 6:
				getHistoryRequest();
				break;
			case 7:
				getMessageAcknowlegementsRequest();
				break;
			case 8:
				sendMessageRequest();
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Wrong option");
				break;
			}
			
		}
		
	}
	private ActorType createDummyActor() {
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(actorId);
		actor.setType(actorType);
		actor.setQuality(actorQuality);
		actor.setName(actorName);
		return actor;
	}
	private void getBoxInfoRequest() throws XmlMappingException, IOException {
		
		ActorType actor = createDummyActor();
		try {
			GetBoxInfoResponseType response = consultationClient.getBoxInfo(actor);
			
			System.out.println(response);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		
	}
	
	private void getMessagesListRequest() throws XmlMappingException, IOException {
		
		ActorType actor = createDummyActor();
		
		try {
			GetMessageListResponseType response = consultationClient.getMessageList(actor, source, startIndex, endIndex, null);
			System.out.println(response);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
	}
	
	private void getFullMessageRequest() throws XmlMappingException, IOException {
	
		ActorType actor = createDummyActor();
		try {
			GetFullMessageResponseType response = consultationClient.getFullMessage(actor, source, messageId);
			System.out.println(response);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
	}
	
	private void moveMessageRequest() throws XmlMappingException, IOException {
		
		ActorType actor = createDummyActor();
		try {
			MoveMessageResponseType response = consultationClient.moveMessages(actor, source, destination, 
					new ArrayList<String>(Arrays.asList(messageId1, messageId2)));
			System.out.println(response);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
	}	
		
	private void deleteMessageRequest() throws XmlMappingException, IOException {	
		
		ActorType actor = createDummyActor();
		try {
			DeleteMessageResponseType response = consultationClient.deleteMessages(actor, source,
					new ArrayList<String>(Arrays.asList(messageId1, messageId2)));
			System.out.println(response);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}	
	}
	
	private void getHistoryRequest() throws XmlMappingException, IOException {
		
		ActorType actor = createDummyActor();
		try {
			GetHistoryResponseType response = consultationClient.getHistory(actor, source, messageId1);
			System.out.println(response);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
	}
	
	private void getMessageAcknowlegementsRequest() throws XmlMappingException, IOException {
		
		ActorType actor = createDummyActor();
		try {
			GetMessageAcknowledgmentsStatusResponseType response = consultationClient.getMessageAcknowlegments(actor, messageId1, null, null);
			System.out.println(response);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
	}
	
	private void sendMessageRequest() throws XmlMappingException, IOException {
		
		ActorType actor = createDummyActor();
		
		DestinationContextType destinationContext1 = PUBLICATION_OBJECT_FACTORY.createDestinationContextType();
		destinationContext1.setId(destId1);
		destinationContext1.setType(destType1);
		destinationContext1.setQuality(destQuality1);
		
		DestinationContextType destinationContext2 = PUBLICATION_OBJECT_FACTORY.createDestinationContextType();
		destinationContext2.setId(destId2);
		destinationContext2.setType(destType2);
		destinationContext2.setQuality(destQuality2);
		
		List<DestinationContextType> destContext = new ArrayList<DestinationContextType>(Arrays.asList(destinationContext1, destinationContext2));
		
		ContentContextType contentContext = new ContentContextType();
		PublicationDocumentType docType = new PublicationDocumentType();
		docType.setTitle(docTitle);
		docType.setEncryptableContent(docContent.getBytes());
		PublicationContentType pubContType = new PublicationContentType();
		pubContType.setDocument(docType);
		ContentSpecificationType specType = new ContentSpecificationType();
		specType.setContentType(contentType);
		
		contentContext.setContent(pubContType);
		contentContext.setContentSpecification(specType);
		
		
		try {
			SendMessageResponse response = publicationClient.sendMessage(publicationId, actor, destContext, contentContext, null);
			System.out.println(response);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
	}
	
	
	
}
