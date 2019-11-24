package com.dit.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dit.test.model.DateModel;
import com.dit.test.service.DateService;

@Controller
public class DateController {
	
	@Autowired
	DateService dateService;
	
	@GetMapping("/datediff") 
    public String getDateDiff(Model model) { 
		model.addAttribute("datediff", new DateModel()); 
        return "forms/date_form";
    }
	
	@PostMapping("/datediff")
    public String submitDates(DateModel dateModel, Model model) { 
		model.addAttribute("datediff", new DateModel()); 
		model.addAttribute("submitted", true); 
        try {
        	model.addAttribute("success", true); 
        	model.addAttribute("daydiff", dateService.calcDateDiff(dateModel)); 
        	
        }catch(Exception ex) {
        	model.addAttribute("success", false); 
        	model.addAttribute("error", ex.getLocalizedMessage()); 
        }
        
        return "forms/date_form";
    }

}
