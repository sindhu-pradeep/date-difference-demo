package com.dit.test.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DateModel {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String startDate;
	
	private String endDate;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
}
