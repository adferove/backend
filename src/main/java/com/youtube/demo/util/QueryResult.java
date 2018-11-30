package com.youtube.demo.util;

import java.util.List;

public class QueryResult {

	private int totalResult;
	private List<Object> listRecord;
	
	public int getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
	public List<Object> getListRecord() {
		return listRecord;
	}
	public void setListRecord(List<Object> listRecord) {
		this.listRecord = listRecord;
	}
	
	
}
