package com.example.SpringBoot_OTPsender.com.services;

import java.util.Random;

import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl  implements UserService{

	@Override
	public String generateOtp(String Username) {
		// TODO Auto-generated method stub
		Random random =new Random();
		int otp=100000+random.nextInt(999999);
		String value=String.valueOf(otp);
		
		return value;
	}

	

}
