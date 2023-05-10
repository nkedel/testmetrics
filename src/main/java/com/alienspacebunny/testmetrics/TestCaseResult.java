package com.alienspacebunny.testmetrics;

public class TestCaseResult {
    public TestCaseResult(long testId, long timeStamp, String commitHash, String buildKey, TestStatus status, int flakiness) {
        this.testId = testId;
        this.timeStamp = timeStamp;
        this.commitHash = commitHash;
        this.buildKey = buildKey;
        this.status = status;
        this.flakiness = flakiness;
    }

    //    ID          BIGINT AUTO_INCREMENT PRIMARY KEY,
    long id;
    //    TEST_ID     BIGINT NOT NULL,
    long testId;
    //    TIMESTAMP   BIGINT NOT NULL,
    long timeStamp;
    //    COMMIT_HASH VARCHAR(41) NOT NULL,
    String commitHash;
    //    BUILD_KEY   VARCHAR(256) NOT NULL,
    String buildKey;
    //    STATUS      VARCHAR(8) NOT NULL,
    TestStatus status;
    //    FLAKYINESS  INT DEFAULT 0,
    int flakiness;
}
