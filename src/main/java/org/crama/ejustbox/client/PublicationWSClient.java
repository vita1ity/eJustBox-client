package org.crama.ejustbox.client;

import java.io.IOException;
import java.util.List;

import org.crama.ejustbox.error.EJustBoxClientException;
import org.springframework.oxm.XmlMappingException;

import be.fgov.ejustice.ejustbox.core.v1.ActorType;
import be.fgov.ejustice.ejustbox.core.v1.CustomMetaType;
import be.fgov.ejustice.ejustbox.core.v1.MetaType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.ContentContextType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.DestinationContextType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.PublicationContentType;
import be.fgov.ejustice.ejustbox.publication.protocol.v1.SendMessageResponse;

public interface PublicationWSClient {

	SendMessageResponse sendMessage( String publicationId, ActorType actor, List<DestinationContextType> destinationContext, 
			ContentContextType contentContext, List<MetaType> metaList) 
			throws EJustBoxClientException, XmlMappingException, IOException;
	
}
