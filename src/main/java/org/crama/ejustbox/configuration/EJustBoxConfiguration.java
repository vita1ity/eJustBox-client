package org.crama.ejustbox.configuration;

import org.crama.ejustbox.client.ConsultationWSClient;
import org.crama.ejustbox.client.ConsultationWSClientImpl;
import org.crama.ejustbox.client.PublicationWSClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class EJustBoxConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		
		marshaller.setContextPath("org.crama.ejustbox.model");
		return marshaller;
	}

	@Bean
	public ConsultationWSClientImpl consultationClient(Jaxb2Marshaller marshaller) {
		ConsultationWSClientImpl client = new ConsultationWSClientImpl();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
	@Bean
	public PublicationWSClientImpl publicationClient(Jaxb2Marshaller marshaller) {
		PublicationWSClientImpl client = new PublicationWSClientImpl();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
}
