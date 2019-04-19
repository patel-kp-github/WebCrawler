package com.GE.WebCrawler.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GE.WebCrawler.service.interfaces.IWebPageProcessor;

@RestController
@RequestMapping("/crawl")
public class CrawlController {

	@Autowired
	IWebPageProcessor process;
	
	@RequestMapping("/hello")
	public String helloMethod() {
		System.out.println("inside hello..........");
		return "HELLO GE Bangalore ...!!!!";
	}

	@RequestMapping("/parse")
	public Map<String, List<String>> crawlController(@RequestBody Map<String, List> internetInput) {
		return process.processRequestPages(internetInput);
	}

	@RequestMapping("/parse/URL")
	public Map<String, List<String>> crawlController(@RequestParam("URL") String URL) {
		System.out.println("crawlController  URL.........."+URL);
		return process.processSinglePage(URL);
	}

}
