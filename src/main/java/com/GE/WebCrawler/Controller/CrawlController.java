package com.GE.WebCrawler.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GE.WebCrawler.service.interfaces.IWebPageProcessor;

@RestController
@RequestMapping("/crawl")
public class CrawlController {

	@Autowired
	IWebPageProcessor process;

	@RequestMapping("/parse")
	public Map<String, List<String>> crawlController(@RequestBody Map<String, List> internetInput) {
		return process.processRequestPages(internetInput);
	}

}
