package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.service.emailservice;


@RestController
public class emailcontroller {
	@Autowired emailservice service;
	@PostMapping("/mail")
	public String senddata(@RequestParam String rece,@RequestParam String sub,@RequestParam String body) {
		return service.sendmail(rece, sub, body);
	}
}			