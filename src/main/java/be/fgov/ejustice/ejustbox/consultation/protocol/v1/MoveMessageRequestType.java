//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.26 at 06:36:06 PM EEST 
//


package be.fgov.ejustice.ejustbox.consultation.protocol.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import be.fgov.ejustice.ejustbox.core.v1.ActorType;


/**
 * <p>Java class for MoveMessageRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MoveMessageRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Actor" type="{urn:be:fgov:ejustice:ejustbox:core:v1}ActorType"/&gt;
 *         &lt;element name="Source"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="INBOX"/&gt;
 *               &lt;enumeration value="SENTBOX"/&gt;
 *               &lt;enumeration value="BININBOX"/&gt;
 *               &lt;enumeration value="BINSENTBOX"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Destination"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="INBOX"/&gt;
 *               &lt;enumeration value="SENTBOX"/&gt;
 *               &lt;enumeration value="BININBOX"/&gt;
 *               &lt;enumeration value="BINSENTBOX"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MessageId" type="{urn:be:fgov:ejustice:ejustbox:core:v1}MessageIdType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MoveMessageRequestType", propOrder = {
    "actor",
    "source",
    "destination",
    "messageId"
})
public class MoveMessageRequestType {

    @XmlElement(name = "Actor", required = true)
    protected ActorType actor;
    @XmlElement(name = "Source", required = true)
    protected String source;
    @XmlElement(name = "Destination", required = true)
    protected String destination;
    @XmlElement(name = "MessageId", required = true)
    protected List<String> messageId;

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
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestination(String value) {
        this.destination = value;
    }

    /**
     * Gets the value of the messageId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMessageId() {
        if (messageId == null) {
            messageId = new ArrayList<String>();
        }
        return this.messageId;
    }

	@Override
	public String toString() {
		return "MoveMessageRequestType [actor=" + actor + ", source=" + source + ", destination=" + destination
				+ ", messageId=" + messageId + "]";
	}
    
    

}
