//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.26 at 06:38:38 PM EEST 
//


package be.fgov.ejustice.ejustbox.publication.protocol.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import be.fgov.ejustice.ejustbox.core.v1.ActorType;
import be.fgov.ejustice.ejustbox.core.v1.MetaType;


/**
 * Publish a new encrypted or non-encrypted message
 * 
 * <p>Java class for PublicationMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublicationMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Actor" type="{urn:be:fgov:ejustice:ejustbox:core:v1}ActorType"/&gt;
 *         &lt;element name="DestinationContext" type="{urn:be:fgov:ejustice:ejustbox:publication:protocol:v1}DestinationContextType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="ContentContext" type="{urn:be:fgov:ejustice:ejustbox:publication:protocol:v1}ContentContextType"/&gt;
 *         &lt;element name="Meta" type="{urn:be:fgov:ejustice:ejustbox:core:v1}MetaType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PublicationId" type="{urn:be:fgov:ejustice:ejustbox:core:v1}PublicationIdType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicationMessageType", propOrder = {
    "actor",
    "destinationContext",
    "contentContext",
    "meta"
})
public class PublicationMessageType {

    @XmlElement(name = "Actor", required = true)
    protected ActorType actor;
    @XmlElement(name = "DestinationContext", required = true)
    protected List<DestinationContextType> destinationContext;
    @XmlElement(name = "ContentContext", required = true)
    protected ContentContextType contentContext;
    @XmlElement(name = "Meta")
    protected List<MetaType> meta;
    @XmlAttribute(name = "PublicationId")
    protected String publicationId;

    /**
     * Gets the value of the actor property.
     * 
     * @return
     *     possible object is
     *     {@link ActorType }
     *     
     */
    public ActorType getActor() {
        return actor;
    }

    /**
     * Sets the value of the actor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActorType }
     *     
     */
    public void setActor(ActorType value) {
        this.actor = value;
    }

    /**
     * Gets the value of the destinationContext property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the destinationContext property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDestinationContext().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DestinationContextType }
     * 
     * 
     */
    public List<DestinationContextType> getDestinationContext() {
        if (destinationContext == null) {
            destinationContext = new ArrayList<DestinationContextType>();
        }
        return this.destinationContext;
    }

    /**
     * Gets the value of the contentContext property.
     * 
     * @return
     *     possible object is
     *     {@link ContentContextType }
     *     
     */
    public ContentContextType getContentContext() {
        return contentContext;
    }

    /**
     * Sets the value of the contentContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentContextType }
     *     
     */
    public void setContentContext(ContentContextType value) {
        this.contentContext = value;
    }

    /**
     * Gets the value of the meta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MetaType }
     * 
     * 
     */
    public List<MetaType> getMeta() {
        if (meta == null) {
            meta = new ArrayList<MetaType>();
        }
        return this.meta;
    }

    /**
     * Gets the value of the publicationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationId() {
        return publicationId;
    }

    /**
     * Sets the value of the publicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationId(String value) {
        this.publicationId = value;
    }

	@Override
	public String toString() {
		return "PublicationMessageType [actor=" + actor + ", destinationContext=" + destinationContext
				+ ", contentContext=" + contentContext + ", meta=" + meta + ", publicationId=" + publicationId + "]";
	}

    
    
    
}
