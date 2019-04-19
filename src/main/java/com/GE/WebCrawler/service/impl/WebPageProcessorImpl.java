package com.GE.WebCrawler.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.Link;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.GE.WebCrawler.Utils.Constants;
import com.GE.WebCrawler.service.interfaces.IWebPageParserService;
import com.GE.WebCrawler.service.interfaces.IWebPageProcessor;

@Service
public class WebPageProcessorImpl implements IWebPageProcessor {

	@Autowired
	IWebPageParserService iParserService;

	private List<String> validList = new ArrayList<>();

	private List<String> skippedList = new ArrayList<>();

	private List<String> inValidList = new ArrayList<>();

	private List<String> visitedList = new ArrayList<>();

	@Override
	public Map<String, List<String>> processSinglePage(String URL) {
		validateLink(URL);
		return prepareOutput();
	}

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
		if (!visitedList.contains(URL))
			visitedList.add(URL);
		return iParserService.IsValidPage(URL);
	}

}
