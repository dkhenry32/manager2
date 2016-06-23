package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }

}
/*package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.myapp.dao.Member;

@Controller
public class GreetingController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public String greeting(Model model){
		
	//Member me =	jdbcTemplate.queryForObject("select * FROM member", Member.class);
		//model = new Greeting();
		Greeting greet = new Greeting();
		greet.firstName = "Darrell";
		model.addAttribute("greeting", greet);

		return "greeting";
	}
	
	@RequestMapping(value="/greeting", method=RequestMethod.POST)
	public String saveLastName(@ModelAttribute Greeting greeting, Model model){
	//     model.addAttribute("finished", "Thanks For updating your last name");
	     
	     greeting.firstName = "NotDarrell";
		greeting.finished = greeting.lastName;
		model.addAttribute("greeting", greeting);
	     return "greeting";
	}
	
}

*/
