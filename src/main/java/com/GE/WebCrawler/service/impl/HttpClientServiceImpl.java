package com.GE.WebCrawler.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

import com.GE.WebCrawler.service.interfaces.IHttpClientService;

@Service
public class HttpClientServiceImpl implements IHttpClientService {

	@Override
	public boolean IsValidPage(String URL) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(URL);
		HttpResponse response = null;
		System.out.println("code 1: ");
		try {
			response = client.execute(httpget);
			System.out.println("code 2: "+response);
			int code = response.getStatusLine().getStatusCode();
			System.out.println("code: "+code);
			if (code / 100 != 2)
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	

}
