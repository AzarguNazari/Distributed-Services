
package backend.rz.uniba.de;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="TASK"/&gt;
 *     &lt;enumeration value="ENHANCEMENT"/&gt;
 *     &lt;enumeration value="BUG"/&gt;
 *     &lt;enumeration value="QUESTION"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "type")
@XmlEnum
public enum Type {

    TASK,
    ENHANCEMENT,
    BUG,
    QUESTION;

    public String value() {
        return name();
    }

    public static Type fromValue(String v) {
        return valueOf(v);
    }

}
