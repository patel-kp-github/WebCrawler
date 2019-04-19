package com.GE.WebCrawler.adoptor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.GE.WebCrawler.service.interfaces.IURLListAdaptorInterface;

@Component
public class URLListAdaptor implements IURLListAdaptorInterface {

	private List<String> validList = new ArrayList<>();
	private List<String> skippedList = new ArrayList<>();
	private List<String> inValidList = new ArrayList<>();
	private List<String> visitedList = new ArrayList<>();

	@Override
	public List<String> getValidList() {
		return validList;
	}

	@Override
	public void addValidList(String URL) {
		validList.add(URL);
	}

	@Override
	public boolean containsValidList(String URL) {
		return validList.contains(URL);
	}

	@Override
	public List<String> getSkippedList() {
		return skippedList;
	}

	@Override
	public void addSkippedList(String URL) {
		skippedList.add(URL);
	}

	@Override
	public boolean containsSkippedList(String URL) {
		return skippedList.contains(URL);
	}

	@Override
	public List<String> getInValidList() {
		return inValidList;
	}

	@Override
	public void addInValidList(String URL) {
		inValidList.add(URL);
	}

	@Override
	public boolean containsInValidList(String URL) {
		return inValidList.contains(URL);
	}

	@Override
	public List<String> getVisitedList() {
		return visitedList;
	}

	@Override
	public void addVisitedList(String URL) {
		visitedList.add(URL);
	}

	@Override
	public boolean containsVisitedList(String URL) {
		return visitedList.contains(URL);
	}

}
