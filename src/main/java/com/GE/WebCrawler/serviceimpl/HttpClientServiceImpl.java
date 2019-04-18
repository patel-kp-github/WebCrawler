package com.GE.WebCrawler.serviceimpl;

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

import com.GE.WebCrawler.service.HttpClientService;

@Service
public class HttpClientServiceImpl implements HttpClientService {

	@Override
	public boolean IsValidPage(String URL) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(URL);
		HttpResponse response = null;
		try {
			response = client.execute(httpget);
			int code = response.getStatusLine().getStatusCode();
			if (code / 100 != 2)
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<String> getListOfLinks(String URL) {
		List<String> ListOfLinks = new ArrayList<String>();
		URL url;
		InputStream is = null;
		BufferedReader br;
		String line;

		try {
			url = new URL(URL);
			is = url.openStream(); // throws an IOException
			br = new BufferedReader(new InputStreamReader(is));

			while ((line = br.readLine()) != null) {
				if (line.contains("href="))
					ListOfLinks.add(line.trim());
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException ioe) {
				// exception
			}
		}
		return ListOfLinks;
	}

}
