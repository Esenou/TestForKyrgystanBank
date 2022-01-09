package com.example.test.model.xmlModel;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "user")
public class UserModelXml implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlAttribute
    private Long id;

    @XmlElement
    private String userName;

    public UserModelXml(Long id, String userName) {
        super();
        this.id = id;
        this.userName = userName;
    }

    public UserModelXml(){}

    @Override
    public String toString() {
        return "UserModelXml{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
