package com.run;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Application {
	private static Logger logger = Logger.getLogger(Application.class);
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		logger.info("Application started");
		MultiplayRunner runner = new MultiplayRunner();
		runner.runMultiplayStorrage("data");
		logger.info("Application stopped");
	}
}
