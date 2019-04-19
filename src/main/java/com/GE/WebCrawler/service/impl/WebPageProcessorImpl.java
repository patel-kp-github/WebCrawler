package com.GE.WebCrawler.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GE.WebCrawler.Utils.Constants;
import com.GE.WebCrawler.service.interfaces.IHttpBaseApiService;
import com.GE.WebCrawler.service.interfaces.IWebPageProcessor;

@Service
public class WebPageProcessorImpl implements IWebPageProcessor {

	@Autowired
	IHttpBaseApiService iHttpBaseApiService;

	private List<String> validList = new ArrayList<>();

	private List<String> skippedList = new ArrayList<>();

	private List<String> inValidList = new ArrayList<>();

	private List<String> visitedList = new ArrayList<>();

	@Override
	public Map<String, List<String>> processRequestPages(Map<String, List> internetInput) {
		List<Map> pageList = internetInput.containsKey(Constants.PAGES) ? internetInput.get(Constants.PAGES)
				: Collections.emptyList();
		for (Map addressMap : pageList) {
			String URL = (String) addressMap.get(Constants.ADDRESS);
			validateLink(URL);
			List<String> links = (List<String>) addressMap.get(Constants.LINKES);
			for (String Link : links) {
				validateLink(URL);
			}

		}
		return prepareOutput();
	}

	private Map<String, List<String>> prepareOutput() {

		Map<String, List<String>> output = new HashMap<>();
		output.put("Success:", validList);
		output.put("Skipped:", skippedList);
		output.put("Error:", inValidList);
		return output;
	}

	private void validateLink(String URL) {
		if (!isVisitedURL(URL)) {
			if (validURL(URL))
				validList.add(URL);
			else
				inValidList.add(URL);
		} else {
			if (availableInValid(URL))
				if (!availableInSkipped(URL))
					skippedList.add(URL);
		}
	}

	private boolean isVisitedURL(String uRL) {
		if (visitedList.contains(uRL))
			return true;
		return false;
	}

	private boolean availableInInValid(String uRL) {
		if (inValidList.contains(uRL))
			return true;
		return false;
	}

	private boolean availableInSkipped(String uRL) {
		if (skippedList.contains(uRL))
			return true;
		return false;
	}

	private boolean availableInValid(String uRL) {
		if (validList.contains(uRL))
			return true;
		return false;
	}

	private boolean validURL(String URL) {
		visitedList.add(URL);
		return iHttpBaseApiService.IsValidPage(URL);
	}

}
