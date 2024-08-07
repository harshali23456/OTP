package com.example.SpringBoot_OTPsender.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringBoot_OTPsender.com.services.OTPService;
import com.example.SpringBoot_OTPsender.com.services.UserService;


@Controller
public class UserController {
	String otp;
	@Autowired
	private UserService userservice;
	@Autowired
	private OTPService otpservice;
	@GetMapping("/login")
     public String getLogin(Model model) {
		
		return "adminlogin";
    	 
     }
	@GetMapping("/loginsts")
	public String getOtp(@RequestParam ("username") String Username,Model model) {
		String demo="+91"+Username;
		otp=userservice.generateOtp(Username);
	    otpservice.sendotp(demo,otp);
	    System.out.println(otp);
	    model.addAttribute("otp", otp);
		return "success";
	}
	
	 @GetMapping("/verify")
	    public String verifyOtpPage() {
	        return "verify";
	    }
	    
	    @PostMapping("/verifyotp")
	    public String verifyotp(@RequestParam("otp") String enteredOtp, Model model) {
	        if (enteredOtp.equals(this.otp)) {
	            model.addAttribute("message", "OTP verified successfully!");
	            return "verify";
	        } else {
	            model.addAttribute("message", "Invalid OTP, please try again.");
	            return "error";
	        }
	    }
}
