package ru.zinovev.springboot.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class BaseController {
	
	@GetMapping()
	public String begin() {
	    return "base";
	}

	@GetMapping("/info")
	public String userData(Principal principal) {
		return principal.getName();
	}

}
