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


/**
 * <p>Java class for DeleteMessageResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeleteMessageResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:be:fgov:ejustice:commons:protocol:v1}StatusResponseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="MessageId" type="{urn:be:fgov:ejustice:ejustbox:core:v1}MessageIdType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeleteMessageResponseType", propOrder = {
    "messageId"
})
public class DeleteMessageResponseType
    extends StatusResponseType
{

    @XmlElement(name = "MessageId")
    protected List<String> messageId;

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
		return "DeleteMessageResponseType [messageId=" + messageId + ", status=" + status + ", id=" + id
				+ ", inResponseTo=" + inResponseTo + ", issueInstant=" + issueInstant + "]";
	}
    
    

}
