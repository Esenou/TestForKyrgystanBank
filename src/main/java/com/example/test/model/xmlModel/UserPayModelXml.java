package com.example.test.model.xmlModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pay")
public class UserPayModelXml extends UserModelXml {

    @XmlElement
    private String pay;

    public UserPayModelXml(Long id, String userName, String pay) {
        super(id, userName);
        this.pay = pay;
    }

    public UserPayModelXml(){

    }

    @Override
    public String toString() {
        return "UserPayModelXml{" +
                "pay='" + pay + '\'' +
                '}';
    }
}
