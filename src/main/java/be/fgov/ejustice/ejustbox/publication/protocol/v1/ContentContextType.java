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
import be.fgov.ejustice.ejustbox.core.v1.CustomMetaType;


/**
 * <p>Java class for ContentContextType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentContextType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Content" type="{urn:be:fgov:ejustice:ejustbox:publication:protocol:v1}PublicationContentType"/&gt;
 *         &lt;element name="ContentSpecification" type="{urn:be:fgov:ejustice:ejustbox:publication:protocol:v1}ContentSpecificationType"/&gt;
 *         &lt;element name="CustomMeta" type="{urn:be:fgov:ejustice:ejustbox:core:v1}CustomMetaType" maxOccurs="50" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentContextType", propOrder = {
    "content",
    "contentSpecification",
    "customMeta"
})
public class ContentContextType {

    @XmlElement(name = "Content", required = true)
    protected PublicationContentType content;
    @XmlElement(name = "ContentSpecification", required = true)
    protected ContentSpecificationType contentSpecification;
    @XmlElement(name = "CustomMeta")
    protected List<CustomMetaType> customMeta;

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link PublicationContentType }
     *     
     */
    public PublicationContentType getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicationContentType }
     *     
     */
    public void setContent(PublicationContentType value) {
        this.content = value;
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

}
