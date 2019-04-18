package com.GE.WebCrawler.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GE.WebCrawler.Utils.Constants;
import com.GE.WebCrawler.service.CrawlService;
import com.GE.WebCrawler.service.Processor;

@Service
public class ProcessorImpl implements Processor {

	@Autowired
	CrawlService crawlService;

	List<String> validList = new ArrayList<>();

	List<String> skippedList = new ArrayList<>();

	List<String> inValidList = new ArrayList<>();

	@Override
	public Map<String, List<String>> processSinglePage(String URL) {
		ProceeURL(URL);
		return prepareOutput();
	}

	@Override
	public Map<String, List<String>> processRequestPages(Map<String, List> internetInput) {

		List<Map> pageList = internetInput.containsKey(Constants.PAGES) ? internetInput.get(Constants.PAGES)
				: Collections.emptyList();

		for (Map addressMap : pageList) {

			String URL = (String) addressMap.get(Constants.ADDRESS);
			ProceeURL(URL);
			List<String> links = (List<String>) addressMap.get(Constants.LINKES);
			for (String Link : links) {
				ProceeURL(URL);
			}

		}
		return prepareOutput();
	}

	private void ProceeURL(String URL) {
		putInLists(URL);
	}

	private Map<String, List<String>> prepareOutput() {

		Map<String, List<String>> output = new HashMap<>();
		output.put("Success:", validList);
		output.put("Skipped:", skippedList);
		output.put("Error:", inValidList);
		return output;
	}

	void putInLists(String URL) {
		if (crawlService.IsValid(URL)) {
			if (!crawlService.IsDuplicate(URL))
				validList.add(URL);
			else {
				if (!skippedList.contains(URL))
					skippedList.add(URL);
			}
		} else
			inValidList.add(URL);
	}

}
