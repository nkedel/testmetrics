package com.alienspacebunny.testmetrics;

public class TestWithStats {
//    ID         BIGINT AUTO_INCREMENT PRIMARY KEY,
    long id;
//    META_BUILD VARCHAR(64) NOT NULL,
    String metaBuild;
//    CLASS_NAME    VARCHAR(512) NOT NULL,
    String className;
//    NAME       VARCHAR(512) NOT NULL,
    String testName;
//    COUNT      BIGINT DEFAULT 0,
    long count;
//    TOTAL_TIME BIGINT DEFAULT 0,
    long totalTime;
//    SUCCESSES  BIGINT DEFAULT 0,
    long successes;
//    FAILURES   BIGINT DEFAULT 0
    long failures;

    public TestWithStats(String metaBuild, String className, String testName, long count, long totalTime, long successes, long failures) {
        this.metaBuild = metaBuild;
        this.className = className;
        this.testName = testName;
        this.count = count;
        this.totalTime = totalTime;
        this.successes = successes;
        this.failures = failures;
    }
}
