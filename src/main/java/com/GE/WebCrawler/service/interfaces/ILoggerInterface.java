package com.GE.WebCrawler.service.interfaces;

public interface ILoggerInterface {

	void info(Object message);

	void error(Object message);

	void info(Object message, Throwable t);

}
