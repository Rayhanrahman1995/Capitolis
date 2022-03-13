package capitolis.qa.reports;

public class LoggerClass {

	public static void log(String msg) {
		Java_Logger.getLog(msg);
		Log4j.logInfo(msg);
	}

}
