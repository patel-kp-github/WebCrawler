package com.GE.WebCrawler.service.impl;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.GE.WebCrawler.service.interfaces.IHttpBaseApiService;

@Service
public class HttpBaseApiServiceImpl implements IHttpBaseApiService {

	@Override
	public boolean IsValidPage(String URL) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpStatus responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, String.class).getStatusCode();
			if (responseEntity.OK == HttpStatus.OK) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}

}
