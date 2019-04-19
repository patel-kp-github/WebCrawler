package com.GE.WebCrawler.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.ContentHandler;

import com.GE.WebCrawler.service.interfaces.IHttpBaseApiService;
import com.GE.WebCrawler.service.interfaces.IHttpClientService;
import com.GE.WebCrawler.service.interfaces.IPageListDataService;
import com.GE.WebCrawler.service.interfaces.IWebPageParserService;;

@Service
public class WebPageParserServiceImpl implements IWebPageParserService, IHttpBaseApiService {

	@Autowired
	IPageListDataService implPageListDataService;
	@Autowired
	IHttpBaseApiService implHttpBaseApiService;

	@Override
	public boolean IsValidPage(String URL) {
		System.out.println("check:" + implHttpBaseApiService.HttpRequestHandler(URL));
		return implHttpBaseApiService.IsValidPage(URL);
	}

	@Override
	public List<String> parsePage(String URL) {
		return implPageListDataService.getListOfLinks(URL);
	}

	@Override
	public boolean HttpRequestHandler(String URL) {
		// TODO Auto-generated method stub
		return implHttpBaseApiService.HttpRequestHandler(URL);
	}

}
