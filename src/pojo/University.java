package pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
public class University {
    String name;
    String alpha_two_code;
    List<String> web_pages;
    String state_province;
    List<String> domains;



    @XmlElement (name = "name")
    public String getName() {
        return name;
    }

    @XmlElement (name = "alpha_two_code")
    public String getAlphaTwoCode() {
        return alpha_two_code;
    }

    @XmlList
    public List<String> getWebPages() {
        return web_pages;
    }

    @XmlElement (name = "state_province")
    public String getStateProvince() {
        return state_province;
    }

    @XmlList
    public List<String> getDomains() {
        return domains;
    }
}