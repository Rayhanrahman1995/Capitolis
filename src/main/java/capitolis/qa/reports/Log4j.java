package capitolis.qa.reports;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {

	public static Logger logger = LogManager.getLogger(Log4j.class.getName());

	public static void logInfo(String msz) {
		logger.log(Level.INFO, msz);
	}

}
