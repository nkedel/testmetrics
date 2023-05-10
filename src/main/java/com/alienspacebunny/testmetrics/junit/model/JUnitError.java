package com.alienspacebunny.testmetrics.junit.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class JUnitError {
    @XmlAttribute
    private String message;
    @XmlAttribute
    private String type;
    @XmlValue
    private String value;

    @Override
    public String toString() {
        return "JUnitError{message='%s', type='%s', value='%s'}".formatted(message, type, value);
    }

    public String getMessage() {
        return this.message;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public JUnitError setMessage(final String message) {
        this.message = message;
        return this;
    }

    public JUnitError setType(final String type) {
        this.type = type;
        return this;
    }

    public JUnitError setValue(final String value) {
        this.value = value;
        return this;
    }
}
