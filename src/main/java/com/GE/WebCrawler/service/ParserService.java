package com.GE.WebCrawler.service;

import java.util.List;

public interface ParserService {

	public boolean IsValid(String URL);
	
	List<String> parsePage(String URL);

}
