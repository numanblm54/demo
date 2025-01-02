package com.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.service.CarService;
import com.car.service.MailService;

@RestController
@RequestMapping("api/mails")
public class MailController {
	
	@Autowired
    private MailService mailService;
	
	@GetMapping("/send-rental-email")
	public String mailSend( @RequestParam String firstName,@RequestParam String lastName) {
			
        try {
        	mailService.sendRentalEmail(firstName, lastName); 
            return "E-post succesfull sended:";
        } catch (Exception e) {
            return "error exist: " + e.getMessage();
        }
	}
	

}
