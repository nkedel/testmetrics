package com.alienspacebunny.testmetrics.junit.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Collection;
import java.util.List;

public class JUnitTestCase {
    @XmlAttribute
    private int assertions;
    @XmlAttribute(name = "classname", required = true)
    private String className;
    @XmlAttribute(required = true)
    private String name;
    @XmlAttribute
    private String status;
    @XmlAttribute
    private Double time;
    @XmlElement
    private JUnitSkipped skipped;
    @XmlElement(name = "error")
    private List<JUnitError> errors;
    @XmlElement(name = "failure")
    private List<JUnitFailure> failures;
    @XmlElement(name = "system-out")
    private String systemOut;
    @XmlElement(name = "system-err")
    private String systemErr;

    @Override
    public String toString() {
        return "JUnitTestCase{className='%s', name='%s', status='%s', time=%s, skipped=%s, errors=%s, failures=%s}"
                .formatted(className, name, status, time, skipped != null ? "skipped" : "", count(errors), count(failures));
    }

    public int getAssertions() {
        return this.assertions;
    }

    public String getClassName() {
        return this.className;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public Double getTime() {
        return this.time;
    }

    public JUnitSkipped getSkipped() {
        return this.skipped;
    }

    public List<JUnitError> getErrors() {
        return this.errors;
    }

    public List<JUnitFailure> getFailures() {
        return this.failures;
    }

    public String getSystemOut() {
        return this.systemOut;
    }

    public String getSystemErr() {
        return this.systemErr;
    }

    public JUnitTestCase setAssertions(final int assertions) {
        this.assertions = assertions;
        return this;
    }

    public JUnitTestCase setClassName(final String className) {
        this.className = className;
        return this;
    }

    public JUnitTestCase setName(final String name) {
        this.name = name;
        return this;
    }

    public JUnitTestCase setStatus(final String status) {
        this.status = status;
        return this;
    }

    public JUnitTestCase setTime(final Double time) {
        this.time = time;
        return this;
    }

    public JUnitTestCase setSkipped(final JUnitSkipped skipped) {
        this.skipped = skipped;
        return this;
    }

    public JUnitTestCase setErrors(final List<JUnitError> errors) {
        this.errors = errors;
        return this;
    }

    public JUnitTestCase setFailures(final List<JUnitFailure> failures) {
        this.failures = failures;
        return this;
    }

    public JUnitTestCase setSystemOut(final String systemOut) {
        this.systemOut = systemOut;
        return this;
    }

    public JUnitTestCase setSystemErr(final String systemErr) {
        this.systemErr = systemErr;
        return this;
    }

    private int count(Collection<?> c) {
        if (c == null || c.isEmpty()) {
            return 0;
        } else {
            return c.size();
        }

    }
}
