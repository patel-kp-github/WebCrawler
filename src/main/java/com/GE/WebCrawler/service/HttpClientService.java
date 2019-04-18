package com.GE.WebCrawler.service;

import java.util.List;

public interface HttpClientService {

	public boolean IsValidPage(String URL);

	public List<String> getListOfLinks(String URL);

}
