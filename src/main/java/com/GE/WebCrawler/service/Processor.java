package com.GE.WebCrawler.service;

import java.util.List;
import java.util.Map;

public interface Processor {
	Map<String, List<String>> processRequestPages(Map<String, List> internetInput);

	Map<String, List<String>> processSinglePage(String URL);
}
