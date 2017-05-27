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
import be.fgov.ejustice.commons.protocol.v1.StatusResponseType;
import be.fgov.ejustice.ejustbox.core.v1.ActorType;
import be.fgov.ejustice.ejustbox.core.v1.ContentInfoType;
import be.fgov.ejustice.ejustbox.core.v1.ContentSpecificationType;
import be.fgov.ejustice.ejustbox.core.v1.CustomMetaType;
import be.fgov.ejustice.ejustbox.core.v1.IdentifierType;
import be.fgov.ejustice.ejustbox.core.v1.MessageInfoType;


/**
 * <p>Java class for GetMessageListResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMessageListResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:be:fgov:ejustice:commons:protocol:v1}StatusResponseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
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
 *         &lt;element name="Message" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="MessageId" type="{urn:be:fgov:ejustice:ejustbox:core:v1}MessageIdType"/&gt;
 *                   &lt;element name="Destination" type="{urn:be:fgov:ejustice:ejustbox:core:v1}IdentifierType"/&gt;
 *                   &lt;element name="Sender" type="{urn:be:fgov:ejustice:ejustbox:core:v1}ActorType"/&gt;
 *                   &lt;element name="MessageInfo" type="{urn:be:fgov:ejustice:ejustbox:core:v1}MessageInfoType"/&gt;
 *                   &lt;element name="ContentInfo" type="{urn:be:fgov:ejustice:ejustbox:core:v1}ContentInfoType" minOccurs="0"/&gt;
 *                   &lt;element name="ContentSpecification" type="{urn:be:fgov:ejustice:ejustbox:core:v1}ContentSpecificationType"/&gt;
 *                   &lt;element name="CustomMeta" type="{urn:be:fgov:ejustice:ejustbox:core:v1}CustomMetaType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMessageListResponseType", propOrder = {
    "source",
    "message"
})
public class GetMessageListResponseType
    extends StatusResponseType
{

    @XmlElement(name = "Source")
    protected String source;
    @XmlElement(name = "Message")
    protected List<GetMessageListResponseType.Message> message;

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
     * Gets the value of the message property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the message property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetMessageListResponseType.Message }
     * 
     * 
     */
    public List<GetMessageListResponseType.Message> getMessage() {
        if (message == null) {
            message = new ArrayList<GetMessageListResponseType.Message>();
        }
        return this.message;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="MessageId" type="{urn:be:fgov:ejustice:ejustbox:core:v1}MessageIdType"/&gt;
     *         &lt;element name="Destination" type="{urn:be:fgov:ejustice:ejustbox:core:v1}IdentifierType"/&gt;
     *         &lt;element name="Sender" type="{urn:be:fgov:ejustice:ejustbox:core:v1}ActorType"/&gt;
     *         &lt;element name="MessageInfo" type="{urn:be:fgov:ejustice:ejustbox:core:v1}MessageInfoType"/&gt;
     *         &lt;element name="ContentInfo" type="{urn:be:fgov:ejustice:ejustbox:core:v1}ContentInfoType" minOccurs="0"/&gt;
     *         &lt;element name="ContentSpecification" type="{urn:be:fgov:ejustice:ejustbox:core:v1}ContentSpecificationType"/&gt;
     *         &lt;element name="CustomMeta" type="{urn:be:fgov:ejustice:ejustbox:core:v1}CustomMetaType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "messageId",
        "destination",
        "sender",
        "messageInfo",
        "contentInfo",
        "contentSpecification",
        "customMeta"
    })
    public static class Message {

        @XmlElement(name = "MessageId", required = true)
        protected String messageId;
        @XmlElement(name = "Destination", required = true)
        protected IdentifierType destination;
        @XmlElement(name = "Sender", required = true)
        protected ActorType sender;
        @XmlElement(name = "MessageInfo", required = true)
        protected MessageInfoType messageInfo;
        @XmlElement(name = "ContentInfo")
        protected ContentInfoType contentInfo;
        @XmlElement(name = "ContentSpecification", required = true)
        protected ContentSpecificationType contentSpecification;
        @XmlElement(name = "CustomMeta")
        protected List<CustomMetaType> customMeta;

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
         * Gets the value of the destination property.
         * 
         * @return
         *     possible object is
         *     {@link IdentifierType }
         *     
         */
        public IdentifierType getDestination() {
            return destination;
        }

        /**
         * Sets the value of the destination property.
         * 
         * @param value
         *     allowed object is
         *     {@link IdentifierType }
         *     
         */
        public void setDestination(IdentifierType value) {
            this.destination = value;
        }

        /**
         * Gets the value of the sender property.
         * 
         * @return
         *     possible object is
         *     {@link ActorType }
         *     
         */
        public ActorType getSender() {
            return sender;
        }

        /**
         * Sets the value of the sender property.
         * 
         * @param value
         *     allowed object is
         *     {@link ActorType }
         *     
         */
        public void setSender(ActorType value) {
            this.sender = value;
        }

        /**
         * Gets the value of the messageInfo property.
         * 
         * @return
         *     possible object is
         *     {@link MessageInfoType }
         *     
         */
        public MessageInfoType getMessageInfo() {
            return messageInfo;
        }

        /**
         * Sets the value of the messageInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageInfoType }
         *     
         */
        public void setMessageInfo(MessageInfoType value) {
            this.messageInfo = value;
        }

        /**
         * Gets the value of the contentInfo property.
         * 
         * @return
         *     possible object is
         *     {@link ContentInfoType }
         *     
         */
        public ContentInfoType getContentInfo() {
            return contentInfo;
        }

        /**
         * Sets the value of the contentInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link ContentInfoType }
         *     
         */
        public void setContentInfo(ContentInfoType value) {
            this.contentInfo = value;
        }

        /**
         * Gets the value of the contentSpecification property.
         * 
         * @return
         *     possible object is
         *     {@link ContentSpecificationType }
         *     
         */
        public ContentSpecificationType getContentSpecification() {
            return contentSpecification;
        }

        /**
         * Sets the value of the contentSpecification property.
         * 
         * @param value
         *     allowed object is
         *     {@link ContentSpecificationType }
         *     
         */
        public void setContentSpecification(ContentSpecificationType value) {
            this.contentSpecification = value;
        }

        /**
         * Gets the value of the customMeta property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the customMeta property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCustomMeta().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CustomMetaType }
         * 
         * 
         */
        public List<CustomMetaType> getCustomMeta() {
            if (customMeta == null) {
                customMeta = new ArrayList<CustomMetaType>();
            }
            return this.customMeta;
        }

		@Override
		public String toString() {
			return "Message [messageId=" + messageId + ", destination=" + destination + ", sender=" + sender
					+ ", messageInfo=" + messageInfo + ", contentInfo=" + contentInfo + ", contentSpecification="
					+ contentSpecification + ", customMeta=" + customMeta + "]";
		}
        
        

    }


	@Override
	public String toString() {
		return "GetMessageListResponseType [source=" + source + ", message=" + message + ", status=" + status + ", id="
				+ id + ", inResponseTo=" + inResponseTo + ", issueInstant=" + issueInstant + "]";
	}
    

}
