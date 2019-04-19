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
import com.GE.WebCrawler.service.interfaces.ILoggerInterface;
import com.GE.WebCrawler.service.interfaces.IURLListAdaptorInterface;
import com.GE.WebCrawler.service.interfaces.IWebPageProcessor;

@Service
public class WebPageProcessorImpl implements IWebPageProcessor {

	@Autowired
	private ILoggerInterface iLoggerInterface;

	@Autowired
	private IURLListAdaptorInterface adaptor;

	@Autowired
	IHttpBaseApiService iHttpBaseApiService;

	@Override
	public Map<String, List<String>> processRequestPages(Map<String, List> internetInput) {
		iLoggerInterface.info(internetInput);
		List<Map> pageList = internetInput.containsKey(Constants.PAGES) ? internetInput.get(Constants.PAGES)
				: Collections.emptyList();
		for (Map addressMap : pageList) {
			String URL = (String) addressMap.get(Constants.ADDRESS);
			validateLink(URL);
			List<String> links = (List<String>) addressMap.get(Constants.LINKES);
			links.stream().forEach((Link) -> validateLink(Link));
			addressMap = null;
		}
		pageList = null;
		Map<String, List<String>> output = new HashMap<>();
		output.put("Success", adaptor.getValidList());
		output.put("Skipped", adaptor.getSkippedList());
		output.put("Error", adaptor.getInValidList());
		return output;
	}

	private void validateLink(String URL) {
		if (!isVisitedURL(URL)) {
			if (validURL(URL))
				adaptor.addValidList(URL);
			else
				adaptor.addInValidList(URL);
		} else {
			if (availableInValid(URL))
				if (!availableInSkipped(URL))
					adaptor.addSkippedList(URL);
		}
	}

	private boolean isVisitedURL(String uRL) {
		if (adaptor.containsVisitedList(uRL))
			return true;
		return false;
	}

	private boolean availableInInValid(String uRL) {
		if (adaptor.containsInValidList(uRL))
			return true;
		return false;
	}

	private boolean availableInSkipped(String uRL) {
		if (adaptor.containsSkippedList(uRL))
			return true;
		return false;
	}

	private boolean availableInValid(String uRL) {
		if (adaptor.containsValidList(uRL))
			return true;
		return false;
	}

	private boolean validURL(String URL) {
		adaptor.addVisitedList(URL);
		return iHttpBaseApiService.IsValidPage(URL);
	}

}
