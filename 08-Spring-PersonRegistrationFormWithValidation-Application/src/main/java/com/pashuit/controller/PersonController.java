package com.pashuit.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pashuit.binding.Person;

@Controller
public class PersonController {

	@GetMapping("/person")
	public String loadForm(Model model) {
		Person personObj = new Person();
		model.addAttribute("person", personObj);
		return "index";
	}
	
	@PostMapping("savePerson")
	public String savePerson(@Valid Person person,BindingResult bindingResult ,Model model) {
		if (bindingResult.hasErrors()) {
			return "index";
		}
		String personName =person.getName() +" record saved successfully";
		model.addAttribute("msg", personName);
		return "data";
	}
}
