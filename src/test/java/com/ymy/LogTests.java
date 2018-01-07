package com.ymy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTests {
    private static final Logger log = LogManager.getLogger(LogTests.class);

    @Test
    public void log() {
        log.trace("trace level");
        log.debug("debug level");
        log.info("info level");
        log.warn("warn level");
        log.error("error level");
        log.fatal("fatal level");
    }
}
