//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.26 at 06:38:38 PM EEST 
//


package be.fgov.ejustice.ejustbox.publication.protocol.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ContentSpecification for publication
 * 
 * <p>Java class for ContentSpecificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentSpecificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:be:fgov:ejustice:ejustbox:core:v1}ContentSpecificationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PublicationReceipt" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="ReceivedReceipt" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="ReadReceipt" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentSpecificationType", propOrder = {
    "publicationReceipt",
    "receivedReceipt",
    "readReceipt"
})
public class ContentSpecificationType
    extends be.fgov.ejustice.ejustbox.core.v1.ContentSpecificationType
{

    @XmlElement(name = "PublicationReceipt", defaultValue = "false")
    protected boolean publicationReceipt;
    @XmlElement(name = "ReceivedReceipt", defaultValue = "false")
    protected boolean receivedReceipt;
    @XmlElement(name = "ReadReceipt", defaultValue = "false")
    protected boolean readReceipt;

    /**
     * Gets the value of the publicationReceipt property.
     * 
     */
    public boolean isPublicationReceipt() {
        return publicationReceipt;
    }

    /**
     * Sets the value of the publicationReceipt property.
     * 
     */
    public void setPublicationReceipt(boolean value) {
        this.publicationReceipt = value;
    }

    /**
     * Gets the value of the receivedReceipt property.
     * 
     */
    public boolean isReceivedReceipt() {
        return receivedReceipt;
    }

    /**
     * Sets the value of the receivedReceipt property.
     * 
     */
    public void setReceivedReceipt(boolean value) {
        this.receivedReceipt = value;
    }

    /**
     * Gets the value of the readReceipt property.
     * 
     */
    public boolean isReadReceipt() {
        return readReceipt;
    }

    /**
     * Sets the value of the readReceipt property.
     * 
     */
    public void setReadReceipt(boolean value) {
        this.readReceipt = value;
    }

	@Override
	public String toString() {
		return "ContentSpecificationType [publicationReceipt=" + publicationReceipt + ", receivedReceipt="
				+ receivedReceipt + ", readReceipt=" + readReceipt + ", applicationName=" + applicationName
				+ ", contentType=" + contentType + ", isImportant=" + isImportant + ", isEncrypted=" + isEncrypted
				+ "]";
	}
    
    

}
