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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import be.fgov.ejustice.commons.protocol.v1.StatusResponseType;
import be.fgov.ejustice.ejustbox.core.v1.EJustboxIdentifierType;


/**
 * <p>Java class for GetMessageAcknowledgmentsStatusResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMessageAcknowledgmentsStatusResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:be:fgov:ejustice:commons:protocol:v1}StatusResponseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="AcknowledgmentsStatus"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Row" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Recipient" type="{urn:be:fgov:ejustice:ejustbox:core:v1}EJustboxIdentifierType"/&gt;
 *                             &lt;element name="Published" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *                             &lt;element name="Received" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *                             &lt;element name="Read" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "GetMessageAcknowledgmentsStatusResponseType", propOrder = {
    "acknowledgmentsStatus"
})
public class GetMessageAcknowledgmentsStatusResponseType
    extends StatusResponseType
{

    @XmlElement(name = "AcknowledgmentsStatus")
    protected GetMessageAcknowledgmentsStatusResponseType.AcknowledgmentsStatus acknowledgmentsStatus;

    /**
     * Gets the value of the acknowledgmentsStatus property.
     * 
     * @return
     *     possible object is
     *     {@link GetMessageAcknowledgmentsStatusResponseType.AcknowledgmentsStatus }
     *     
     */
    public GetMessageAcknowledgmentsStatusResponseType.AcknowledgmentsStatus getAcknowledgmentsStatus() {
        return acknowledgmentsStatus;
    }

    /**
     * Sets the value of the acknowledgmentsStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMessageAcknowledgmentsStatusResponseType.AcknowledgmentsStatus }
     *     
     */
    public void setAcknowledgmentsStatus(GetMessageAcknowledgmentsStatusResponseType.AcknowledgmentsStatus value) {
        this.acknowledgmentsStatus = value;
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
     *         &lt;element name="Row" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Recipient" type="{urn:be:fgov:ejustice:ejustbox:core:v1}EJustboxIdentifierType"/&gt;
     *                   &lt;element name="Published" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
     *                   &lt;element name="Received" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
     *                   &lt;element name="Read" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "row"
    })
    public static class AcknowledgmentsStatus {

        @XmlElement(name = "Row", required = true)
        protected List<GetMessageAcknowledgmentsStatusResponseType.AcknowledgmentsStatus.Row> row;

        /**
         * Gets the value of the row property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the row property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRow().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetMessageAcknowledgmentsStatusResponseType.AcknowledgmentsStatus.Row }
         * 
         * 
         */
        public List<GetMessageAcknowledgmentsStatusResponseType.AcknowledgmentsStatus.Row> getRow() {
            if (row == null) {
                row = new ArrayList<GetMessageAcknowledgmentsStatusResponseType.AcknowledgmentsStatus.Row>();
            }
            return this.row;
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
         *         &lt;element name="Recipient" type="{urn:be:fgov:ejustice:ejustbox:core:v1}EJustboxIdentifierType"/&gt;
         *         &lt;element name="Published" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
         *         &lt;element name="Received" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
         *         &lt;element name="Read" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
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
            "recipient",
            "published",
            "received",
            "read"
        })
        public static class Row {

            @XmlElement(name = "Recipient", required = true)
            protected EJustboxIdentifierType recipient;
            @XmlElement(name = "Published")
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar published;
            @XmlElement(name = "Received")
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar received;
            @XmlElement(name = "Read")
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar read;

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
             * Gets the value of the published property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getPublished() {
                return published;
            }

            /**
             * Sets the value of the published property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setPublished(XMLGregorianCalendar value) {
                this.published = value;
            }

            /**
             * Gets the value of the received property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getReceived() {
                return received;
            }

            /**
             * Sets the value of the received property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setReceived(XMLGregorianCalendar value) {
                this.received = value;
            }

            /**
             * Gets the value of the read property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getRead() {
                return read;
            }

            /**
             * Sets the value of the read property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setRead(XMLGregorianCalendar value) {
                this.read = value;
            }

			@Override
			public String toString() {
				return "Row [recipient=" + recipient + ", published=" + published + ", received=" + received + ", read="
						+ read + "]";
			}
            
            

        }


		@Override
		public String toString() {
			return "AcknowledgmentsStatus [row=" + row + "]";
		}

        
        
    }


	@Override
	public String toString() {
		return "GetMessageAcknowledgmentsStatusResponseType [acknowledgmentsStatus=" + acknowledgmentsStatus
				+ ", status=" + status + ", id=" + id + ", inResponseTo=" + inResponseTo + ", issueInstant="
				+ issueInstant + "]";
	}
    
    

}
