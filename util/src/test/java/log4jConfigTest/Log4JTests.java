package log4jConfigTest;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4JTests {

	public Log4JTests() {
	}

	@Test
	public void loggerTest() {
		Logger logger = Logger.getLogger(Log4JTests.class);

		logger.info("Test log!");
	}
}
