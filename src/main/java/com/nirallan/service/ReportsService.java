package com.nirallan.service;

import java.util.List;

import com.nirallan.request.SearchRequest;
import com.nirallan.response.SearchResponse;

public interface ReportsService {
	public List<String> getplanNames();
	
	public List<String> getPlanStatus();
	
	public List<SearchResponse> getSearchPlans(SearchRequest request);

}
