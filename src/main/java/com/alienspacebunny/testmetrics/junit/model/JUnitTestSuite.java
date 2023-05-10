package com.alienspacebunny.testmetrics.junit.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "testsuite")
public class JUnitTestSuite {
    @XmlAttribute
    private boolean disabled;
    @XmlAttribute
    private int errors;
    @XmlAttribute
    private int failures;
    @XmlAttribute
    private String hostname;
    @XmlAttribute
    private String id;
    @XmlAttribute(required = true)
    private String name;
    @XmlAttribute(name = "package")
    private String pakkage;
    @XmlAttribute
    private int skipped;
    @XmlAttribute(required = true)
    private int tests;
    @XmlAttribute
    private double time;
    @XmlAttribute
    private String timestamp;
    @XmlElement(name = "property")
    @XmlElementWrapper(name = "properties")
    private List<JUnitProperty> properties;
    @XmlElement(name = "testcase")
    private List<JUnitTestCase> testCases;
    @XmlElement(name = "system-out")
    private String systemOut;
    @XmlElement(name = "system-err")
    private String systemErr;

    public String getPackage() {
        return pakkage;
    }

    public void setPackage(String pakkage) {
        this.pakkage = pakkage;
    }

    @Override
    public String toString() {
        return "JUnitTestSuite{package='%s', name='%s', tests=%d, errors=%d, failures=%d, skipped=%d}"
                .formatted(pakkage, name, tests, errors, failures, skipped);
    }

    public boolean isDisabled() {
        return this.disabled;
    }

    public int getErrors() {
        return this.errors;
    }

    public int getFailures() {
        return this.failures;
    }

    public String getHostname() {
        return this.hostname;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getSkipped() {
        return this.skipped;
    }

    public int getTests() {
        return this.tests;
    }

    public double getTime() {
        return this.time;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public List<JUnitProperty> getProperties() {
        return this.properties;
    }

    public List<JUnitTestCase> getTestCases() {
        return this.testCases;
    }

    public String getSystemOut() {
        return this.systemOut;
    }

    public String getSystemErr() {
        return this.systemErr;
    }

    public JUnitTestSuite setDisabled(final boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    public JUnitTestSuite setErrors(final int errors) {
        this.errors = errors;
        return this;
    }

    public JUnitTestSuite setFailures(final int failures) {
        this.failures = failures;
        return this;
    }

    public JUnitTestSuite setHostname(final String hostname) {
        this.hostname = hostname;
        return this;
    }

    public JUnitTestSuite setId(final String id) {
        this.id = id;
        return this;
    }

    public JUnitTestSuite setName(final String name) {
        this.name = name;
        return this;
    }

    public JUnitTestSuite setSkipped(final int skipped) {
        this.skipped = skipped;
        return this;
    }

    public JUnitTestSuite setTests(final int tests) {
        this.tests = tests;
        return this;
    }

    public JUnitTestSuite setTime(final double time) {
        this.time = time;
        return this;
    }

    public JUnitTestSuite setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public JUnitTestSuite setProperties(final List<JUnitProperty> properties) {
        this.properties = properties;
        return this;
    }

    public JUnitTestSuite setTestCases(final List<JUnitTestCase> testCases) {
        this.testCases = testCases;
        return this;
    }

    public JUnitTestSuite setSystemOut(final String systemOut) {
        this.systemOut = systemOut;
        return this;
    }

    public JUnitTestSuite setSystemErr(final String systemErr) {
        this.systemErr = systemErr;
        return this;
    }
}
