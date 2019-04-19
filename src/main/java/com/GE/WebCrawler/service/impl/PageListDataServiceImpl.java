package com.GE.WebCrawler.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.GE.WebCrawler.service.interfaces.IPageListDataService;

public class PageListDataServiceImpl implements IPageListDataService {

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
