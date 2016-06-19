package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.dao.Member;

@Controller
public class GreetingController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping("/greeting")
	public String greeting(Model model){
		
	Member me =	jdbcTemplate.queryForObject("select * FROM member", Member.class);
		
		model.addAttribute("name",me.getName());
		return "greeting";
	}
}
