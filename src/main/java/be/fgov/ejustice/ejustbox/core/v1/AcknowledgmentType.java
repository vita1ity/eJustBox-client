//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.26 at 06:38:38 PM EEST 
//


package be.fgov.ejustice.ejustbox.core.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Specifies content of a Acknowledgment notification
 * 
 * <p>Java class for AcknowledgmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AcknowledgmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageId" type="{urn:be:fgov:ejustice:ejustbox:core:v1}MessageIdType"/&gt;
 *         &lt;element name="Recipient" type="{urn:be:fgov:ejustice:ejustbox:core:v1}EJustboxIdentifierType" minOccurs="0"/&gt;
 *         &lt;element name="AckType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="PUBLISHED"/&gt;
 *               &lt;enumeration value="RECEIVED"/&gt;
 *               &lt;enumeration value="READ"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AcknowledgmentType", propOrder = {
    "messageId",
    "recipient",
    "ackType",
    "dateTime"
})
public class AcknowledgmentType {

    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "Recipient")
    protected EJustboxIdentifierType recipient;
    @XmlElement(name = "AckType", required = true)
    protected String ackType;
    @XmlElement(name = "DateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the recipient property.
     * 
     * @return
     *     possible object is
     *     {@link EJustboxIdentifierType }
     *     
     */
    public EJustboxIdentifierType getRecipient() {
        return recipient;
    }

    /**
     * Sets the value of the recipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link EJustboxIdentifierType }
     *     
     */
    public void setRecipient(EJustboxIdentifierType value) {
        this.recipient = value;
    }

    /**
     * Gets the value of the ackType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAckType() {
        return ackType;
    }

    /**
     * Sets the value of the ackType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAckType(String value) {
        this.ackType = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

	@Override
	public String toString() {
		return "AcknowledgmentType [messageId=" + messageId + ", recipient=" + recipient + ", ackType=" + ackType
				+ ", dateTime=" + dateTime + "]";
	}
    
    

}
