package log4jtest;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {

	private static final Logger LOGGER = Logger.getLogger(Log4jTest.class);

	@Test
	public void testWritOut() {
		LOGGER.info("Info message.");
		LOGGER.warn("Warn message.");
	}

}
