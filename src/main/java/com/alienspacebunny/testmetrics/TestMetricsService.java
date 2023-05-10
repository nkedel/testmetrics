package com.alienspacebunny.testmetrics;

import com.alienspacebunny.testmetrics.junit.model.JUnitTestCase;
import com.alienspacebunny.testmetrics.junit.model.JUnitTestSuite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("testMetricsService")
public class TestMetricsService {
    private final TestWithStatsRepository testWithStatsRepository;
    private final TestCaseResultRepository testCaseResultRepository;

    public TestMetricsService(@Autowired TestWithStatsRepository testWithStatsRepository, @Autowired TestCaseResultRepository testCaseResultRepository) {
        this.testWithStatsRepository = testWithStatsRepository;
        this.testCaseResultRepository = testCaseResultRepository;
    }

    public void processTestCase(String metaBuild, String buildKey, String commitHash, JUnitTestSuite jUnitTestSuite, JUnitTestCase testCase, long receiveTime) {
        TestStatus status = TestStatus.SKIPPED; // fix me
        String testName = testCase.getName();
        ;
        String className = testCase.getClassName();
        int flakiness = 0; // fix me
        long testId = testWithStatsRepository.findIdByMetaBuildAndName(metaBuild, jUnitTestSuite);
        var testCaseResult = new TestCaseResult(testId, receiveTime, commitHash, buildKey, status, flakiness);
        testCaseResultRepository.write(testCaseResult);
    }
}
