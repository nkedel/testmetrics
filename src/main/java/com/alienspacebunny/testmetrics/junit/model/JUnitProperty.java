package com.alienspacebunny.testmetrics.junit.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import jakarta.xml.bind.annotation.XmlAttribute;

public class JUnitProperty {
    @XmlAttribute(required = true)
    private String name;
    @XmlAttribute(required = true)
    private String value;

    @Override
    public String toString() {
        return "Property{name='%s', value='%s'}".formatted(name, value);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public JUnitProperty setName(final String name) {
        this.name = name;
        return this;
    }

    public JUnitProperty setValue(final String value) {
        this.value = value;
        return this;
    }
}
