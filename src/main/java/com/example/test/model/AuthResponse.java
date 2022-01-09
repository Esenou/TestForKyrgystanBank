package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "AuthResponse")
public class AuthResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private String token;

    public AuthResponse(String token) {
        super();
        this.token = token;
    }
    public AuthResponse() {}

    @Override
    public String toString() {
        return "AuthResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
