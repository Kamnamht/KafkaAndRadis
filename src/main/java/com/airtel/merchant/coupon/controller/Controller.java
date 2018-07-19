package com.airtel.merchant.coupon.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@ResponseBody
	@RequestMapping("/ping")
	public String ping()	{
		return "ping"+new Date().toString();
	}
}
