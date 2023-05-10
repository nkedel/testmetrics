package com.alienspacebunny.testmetrics;

import com.alienspacebunny.testmetrics.junit.model.JUnitTestSuite;
import org.springframework.stereotype.Repository;

@Repository
public class TestWithStatsRepository {
    public long findIdByMetaBuildAndName(String metaBuild, JUnitTestSuite jUnitTestSuite) {
        // implement me
        return 0;
    }
}
