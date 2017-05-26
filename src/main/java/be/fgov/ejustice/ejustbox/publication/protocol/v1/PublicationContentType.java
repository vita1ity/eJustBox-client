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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains all elements relative to the content of the message
 * 
 * <p>Java class for PublicationContentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublicationContentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Document" type="{urn:be:fgov:ejustice:ejustbox:publication:protocol:v1}PublicationDocumentType"/&gt;
 *         &lt;element name="EncryptableINSSPerson" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="Annex" type="{urn:be:fgov:ejustice:ejustbox:publication:protocol:v1}PublicationAnnexType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicationContentType", propOrder = {
    "document",
    "encryptableINSSPerson",
    "annex"
})
public class PublicationContentType {

    @XmlElement(name = "Document", required = true)
    protected PublicationDocumentType document;
    @XmlElement(name = "EncryptableINSSPerson")
    protected byte[] encryptableINSSPerson;
    @XmlElement(name = "Annex")
    protected List<PublicationAnnexType> annex;

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link PublicationDocumentType }
     *     
     */
    public PublicationDocumentType getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicationDocumentType }
     *     
     */
    public void setDocument(PublicationDocumentType value) {
        this.document = value;
    }

    /**
     * Gets the value of the encryptableINSSPerson property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getEncryptableINSSPerson() {
        return encryptableINSSPerson;
    }

    /**
     * Sets the value of the encryptableINSSPerson property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setEncryptableINSSPerson(byte[] value) {
        this.encryptableINSSPerson = value;
    }

    /**
     * Gets the value of the annex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the annex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnnex().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PublicationAnnexType }
     * 
     * 
     */
    public List<PublicationAnnexType> getAnnex() {
        if (annex == null) {
            annex = new ArrayList<PublicationAnnexType>();
        }
        return this.annex;
    }

}
