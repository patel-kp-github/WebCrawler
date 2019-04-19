package com.GE.WebCrawler.service.impl;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.GE.WebCrawler.service.interfaces.IHttpBaseApiService;

public class HttpBaseApiServiceImpl implements IHttpBaseApiService {

	@Override
	public boolean HttpRequestHandler(String URL) {
		// TODO Auto-generated method stub
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(URL);
		HttpResponse response = null;
		System.out.println("code 1: ");
		try {
			response = client.execute(httpget);
			System.out.println("code 2: " + response);
			int code = response.getStatusLine().getStatusCode();
			System.out.println("code: " + code);
			if (code / 100 != 2)
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean IsValidPage(String URL) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(URL);
		HttpResponse response = null;
		System.out.println("code 1: ");
		try {
			response = client.execute(httpget);
			System.out.println("code 2: " + response);
			int code = response.getStatusLine().getStatusCode();
			System.out.println("code: " + code);
			if (code / 100 != 2)
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
