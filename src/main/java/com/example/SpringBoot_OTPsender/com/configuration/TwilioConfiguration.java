package com.example.SpringBoot_OTPsender.com.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@Configuration
public class TwilioConfiguration {
	@Value("${twilio.accountsid}")
	private String accountsid;
	@Value("${twilio.authToken}")
	private String authtoken;
	@Value("${twilio.contactNo}")
	private String contactNo;
	
	@PostConstruct
	public void initTwilio() {
		Twilio.init(accountsid,authtoken);
	}
    public String getContactNo() {
		return contactNo;
	}
}
