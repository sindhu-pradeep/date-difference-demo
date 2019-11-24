package com.dit.test.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Service;

import com.dit.test.model.DateModel;

@Service
public class DateService {
	
	@Autowired
	private MessageSource messageSource;
	
	public Long calcDateDiff(DateModel dateModel) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date startDate = sdf.parse(dateModel.getStartDate());
		Date endDate = sdf.parse(dateModel.getEndDate());
		
		if(startDate.after(endDate))
			throw new Exception(messageSource.getMessage("dates.invalid", new Object[0], new Locale("el")));
		
		long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		
		return diff;
		   
	}
	
	

}
