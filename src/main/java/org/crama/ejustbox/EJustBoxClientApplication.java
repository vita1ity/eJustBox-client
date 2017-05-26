package org.crama.ejustbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.crama.ejustbox.client.ConsultationWSClient;
import org.crama.ejustbox.error.EJustBoxClientException;
import org.crama.ejustbox.model.consultation.ActorType2;
import org.crama.ejustbox.model.consultation.DeleteMessageResponseType;
import org.crama.ejustbox.model.consultation.GetBoxInfoResponseType;
import org.crama.ejustbox.model.consultation.GetFullMessageResponseType;
import org.crama.ejustbox.model.consultation.GetHistoryResponseType;
import org.crama.ejustbox.model.consultation.GetMessageAcknowledgmentsStatusResponseType;
import org.crama.ejustbox.model.consultation.GetMessageListResponseType;
import org.crama.ejustbox.model.consultation.MoveMessageResponseType;
import org.crama.ejustbox.model.consultation.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.XmlMappingException;

@SpringBootApplication
public class EJustBoxClientApplication implements CommandLineRunner {

	private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
	
	@Autowired
	private ConsultationWSClient consultationService;
	
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
	
	private void getBoxInfoRequest() 
			throws XmlMappingException, IOException {
		
		ActorType2 actor = OBJECT_FACTORY.createActorType2(actorId, actorType, actorQuality, actorName);
		
		try {
			GetBoxInfoResponseType response = consultationService.getBoxInfo(actor);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			GetMessageListResponseType response = consultationService.getMessageList(actor, source, startIndex, endIndex);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			GetFullMessageResponseType response = consultationService.getFullMessage(actor, source, messageId);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			MoveMessageResponseType response = consultationService.moveMessages(actor, source, destination, 
					new ArrayList<String>(Arrays.asList(messageId1, messageId2)));
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			DeleteMessageResponseType response = consultationService.deleteMessages(actor, source,
					new ArrayList<String>(Arrays.asList(messageId1, messageId2)));
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			GetHistoryResponseType response = consultationService.getHistory(actor, source, messageId1);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
		try {
			GetMessageAcknowledgmentsStatusResponseType response = consultationService.getMessageAcknowlegments(actor, messageId1, null, null);
		}
		catch (EJustBoxClientException ex) {
			System.err.println(ex.getSystemError());
		}
		
	}
	
	
	
}
