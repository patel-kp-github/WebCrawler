package com.GE.WebCrawler.service.interfaces;

import java.util.List;

public interface IURLListAdaptorInterface {

	List<String> getValidList();

	List<String> getSkippedList();

	List<String> getInValidList();

	List<String> getVisitedList();

	void addValidList(String URL);

	void addSkippedList(String URL);

	void addInValidList(String URL);

	void addVisitedList(String URL);

	boolean containsValidList(String URL);

	boolean containsSkippedList(String URL);

	boolean containsInValidList(String URL);

	boolean containsVisitedList(String URL);

}
