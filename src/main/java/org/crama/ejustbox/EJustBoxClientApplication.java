package org.crama.ejustbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	
	
	private static final Logger log = LoggerFactory.getLogger(EJustBoxClientApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(EJustBoxClientApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.setWebEnvironment(false);
        app.run(args);
	
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		log.info("EJustBox Client running...");
		
		getBoxInfoRequest();
		
	
	}
	
	private void menu() {
		
	}
	
	private void getBoxInfoRequest() throws XmlMappingException, IOException {
		
		
		ActorType actor = OBJECT_FACTORY.createActorType();
		actor.setId(actorId);
		actor.setType(actorType);
		actor.setQuality(actorQuality);
		actor.setName(actorName);
		
		try {
			GetBoxInfoResponseType response = consultationClient.getBoxInfo(actor);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			GetMessageListResponseType response = consultationClient.getMessageList(actor, source, startIndex, endIndex);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			GetFullMessageResponseType response = consultationClient.getFullMessage(actor, source, messageId);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			MoveMessageResponseType response = consultationClient.moveMessages(actor, source, destination, 
					new ArrayList<String>(Arrays.asList(messageId1, messageId2)));
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			DeleteMessageResponseType response = consultationClient.deleteMessages(actor, source,
					new ArrayList<String>(Arrays.asList(messageId1, messageId2)));
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			GetHistoryResponseType response = consultationClient.getHistory(actor, source, messageId1);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			GetMessageAcknowledgmentsStatusResponseType response = consultationClient.getMessageAcknowlegments(actor, messageId1, null, null);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		
		//TODO replace with OBJECT_FACTORY
		//TODO combine model
		ActorType actor2 = new ActorType();
		actor2.setId(actorId);
		actor2.setType(actorType);
		actor2.setQuality(actorQuality);
		actor2.setName(actorName);
		
		DestinationContextType destinationContext1 = new DestinationContextType();
		destinationContext1.setId("qwwe");
		destinationContext1.setType("type");
		destinationContext1.setQuality("quality");
		
		DestinationContextType destinationContext2 = new DestinationContextType();
		destinationContext2.setId("qwwe2");
		destinationContext2.setType("type2");
		destinationContext2.setQuality("quality2");
		
		List<DestinationContextType> destContext = new ArrayList<DestinationContextType>(Arrays.asList(destinationContext1, destinationContext2));
		
		ContentContextType contentContext = new ContentContextType();
		PublicationDocumentType docType = new PublicationDocumentType();
		docType.setTitle("Message Title");
		docType.setEncryptableContent(new byte[]{1, 0, 1, 0});
		PublicationContentType pubContType = new PublicationContentType();
		pubContType.setDocument(docType);
		ContentSpecificationType specType = new ContentSpecificationType();
		specType.setApplicationName("app");
		specType.setContentType("text");
		specType.setIsEncrypted(true);
		specType.setIsImportant(true);
		specType.setPublicationReceipt(true);
		specType.setReadReceipt(true);
		specType.setReceivedReceipt(true);
		
		contentContext.setContent(pubContType);
		contentContext.setContentSpecification(specType);
		
		String publicationId = "2387246375262";
		
		try {
			SendMessageResponse response = publicationClient.sendMessage(actor2, destContext, contentContext, publicationId);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
	}
	
	
	
}
