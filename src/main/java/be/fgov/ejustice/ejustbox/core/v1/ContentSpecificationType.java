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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * ContentSpecification for consultation
 * 
 * <p>Java class for ContentSpecificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentSpecificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ApplicationName" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="25"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ContentType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="DOCUMENT"/&gt;
 *               &lt;enumeration value="NEWS"/&gt;
 *               &lt;enumeration value="ACKNOWLEDGMENT"/&gt;
 *               &lt;enumeration value="ERROR"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="IsImportant" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="IsEncrypted" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentSpecificationType", propOrder = {
    "applicationName",
    "contentType",
    "isImportant",
    "isEncrypted"
})
@XmlSeeAlso({
    be.fgov.ejustice.ejustbox.publication.protocol.v1.ContentSpecificationType.class
})
public class ContentSpecificationType {

    @XmlElement(name = "ApplicationName")
    protected String applicationName;
    @XmlElement(name = "ContentType", required = true)
    protected String contentType;
    @XmlElement(name = "IsImportant", defaultValue = "false")
    protected boolean isImportant;
    @XmlElement(name = "IsEncrypted", defaultValue = "false")
    protected boolean isEncrypted;

    /**
     * Gets the value of the applicationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Sets the value of the applicationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationName(String value) {
        this.applicationName = value;
    }

    /**
     * Gets the value of the contentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

    /**
     * Gets the value of the isImportant property.
     * 
     */
    public boolean isIsImportant() {
        return isImportant;
    }

    /**
     * Sets the value of the isImportant property.
     * 
     */
    public void setIsImportant(boolean value) {
        this.isImportant = value;
    }

    /**
     * Gets the value of the isEncrypted property.
     * 
     */
    public boolean isIsEncrypted() {
        return isEncrypted;
    }

    /**
     * Sets the value of the isEncrypted property.
     * 
     */
    public void setIsEncrypted(boolean value) {
        this.isEncrypted = value;
    }

	@Override
	public String toString() {
		return "ContentSpecificationType [applicationName=" + applicationName + ", contentType=" + contentType
				+ ", isImportant=" + isImportant + ", isEncrypted=" + isEncrypted + "]";
	}
    
    

}
