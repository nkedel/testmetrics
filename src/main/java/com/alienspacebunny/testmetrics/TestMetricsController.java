package com.alienspacebunny.testmetrics;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.List;

import com.alienspacebunny.testmetrics.junit.JUnitMarshalling;
import com.alienspacebunny.testmetrics.junit.model.JUnitTestCase;
import com.alienspacebunny.testmetrics.junit.model.JUnitTestSuite;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.XMLStreamException;

@RestController
class TestMetricsController {
    Logger log = LoggerFactory.getLogger(TestMetricsController.class);

    private final TestMetricsService testMetricsService;

    TestMetricsController(@Autowired TestMetricsService testMetricsService) {
        this.testMetricsService = testMetricsService;
    }

    @PostMapping(value = "/submit/{metaBuild}/{buildKey}/{commitHash}",
            consumes = { "application/octet-stream;charset=UTF-8" },
            produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<?> submit(
            @PathVariable(value="metaBuild") final String metaBuild,
            @PathVariable(value="buildKey") final String buildKey,
            @PathVariable(value="commitHash") final String commitHash,
            HttpServletRequest request) {
        long receiveTime = Instant.now().getEpochSecond();
        JUnitTestSuite jUnitTestSuite;
        InputStream stream;
        try {
            stream = request.getInputStream();
        } catch (IOException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try(stream) {
            jUnitTestSuite = JUnitMarshalling.unmarshalTestSuite(stream);
        } catch (JAXBException|XMLStreamException|IOException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (jUnitTestSuite != null) {
            log.info("Received JUnitTestSuite(metabuild='{}', buildKey='{}', commitHash='{}'. {})", metaBuild, buildKey, commitHash, jUnitTestSuite.toString());
            for (JUnitTestCase testCase : jUnitTestSuite.getTestCases()) {
                testMetricsService.processTestCase(metaBuild, buildKey, commitHash, jUnitTestSuite, testCase, receiveTime);
            }
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    private void processTestCase(JUnitTestCase testCase) {
    }

}