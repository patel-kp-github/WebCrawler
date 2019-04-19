package com.GE.WebCrawler.service.interfaces;

public interface IHttpBaseApiService {

	public boolean HttpRequestHandler(String URL);

	boolean IsValidPage(String URL);
	
}
