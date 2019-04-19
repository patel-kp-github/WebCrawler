package com.GE.WebCrawler.service.interfaces;

import java.util.List;

public interface IWebPageParserService {

	public boolean IsValidPage(String URL);
	
	public List<String> parsePage(String URL);

}
