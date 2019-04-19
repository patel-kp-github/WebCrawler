package com.GE.WebCrawler.logger;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.GE.WebCrawler.service.interfaces.ILoggerInterface;

@Component
public class LoggerImpl implements ILoggerInterface {

	private final static Logger logger = Logger.getLogger(LoggerImpl.class);

	@Override
	public void info(Object message) {
		logger.info(message);
	}

	@Override
	public void error(Object message) {
		logger.error(message);
	}

	@Override
	public void info(Object message, Throwable t) {
		logger.info(message, t);
	}

}
