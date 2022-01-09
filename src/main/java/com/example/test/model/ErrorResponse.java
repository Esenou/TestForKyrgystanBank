package com.example.test.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "ErrorResponse")
public class ErrorResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlElement
    private String message;

    @XmlElement
    private String debugMessage;

    public ErrorResponse(String message, String debugMessage) {
        super();
        this.message = message;
        this.debugMessage = debugMessage;
    }

    public ErrorResponse(){}

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                '}';
    }
}
