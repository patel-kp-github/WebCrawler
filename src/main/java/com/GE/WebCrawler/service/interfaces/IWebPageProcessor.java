package com.GE.WebCrawler.service.interfaces;

import java.util.List;
import java.util.Map;

public interface IWebPageProcessor {
	Map<String, List<String>> processRequestPages(Map<String, List> internetInput);

	Map<String, List<String>> processSinglePage(String URL);
}
