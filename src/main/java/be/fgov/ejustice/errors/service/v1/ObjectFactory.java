//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.26 at 06:38:38 PM EEST 
//


package be.fgov.ejustice.errors.service.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the be.fgov.ejustice.errors.service.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SystemError_QNAME = new QName("urn:be:fgov:ejustice:errors:service:v1", "SystemError");
    private final static QName _BusinessError_QNAME = new QName("urn:be:fgov:ejustice:errors:service:v1", "BusinessError");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: be.fgov.ejustice.errors.service.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SystemErrorType }
     * 
     */
    public SystemErrorType createSystemErrorType() {
        return new SystemErrorType();
    }

    /**
     * Create an instance of {@link BusinessErrorType }
     * 
     */
    public BusinessErrorType createBusinessErrorType() {
        return new BusinessErrorType();
    }

    /**
     * Create an instance of {@link ServiceErrorType }
     * 
     */
    public ServiceErrorType createServiceErrorType() {
        return new ServiceErrorType();
    }

    /**
     * Create an instance of {@link TraceType }
     * 
     */
    public TraceType createTraceType() {
        return new TraceType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemErrorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:be:fgov:ejustice:errors:service:v1", name = "SystemError")
    public JAXBElement<SystemErrorType> createSystemError(SystemErrorType value) {
        return new JAXBElement<SystemErrorType>(_SystemError_QNAME, SystemErrorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessErrorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:be:fgov:ejustice:errors:service:v1", name = "BusinessError")
    public JAXBElement<BusinessErrorType> createBusinessError(BusinessErrorType value) {
        return new JAXBElement<BusinessErrorType>(_BusinessError_QNAME, BusinessErrorType.class, null, value);
    }

}
