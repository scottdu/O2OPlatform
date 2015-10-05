package com.o2o.constant;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class Constant {
	
	public static void getInitParameters() {
		loadLogBackConfig();
	}
	
	
	public static void loadLogBackConfig() {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(lc);
		lc.reset();
		try {
			configurator.doConfigure(Constant.class.getClassLoader().getResource("logback.xml"));
		} catch (JoranException e) {
			
		}
	}
}
