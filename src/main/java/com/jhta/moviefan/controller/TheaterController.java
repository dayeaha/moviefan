package com.jhta.moviefan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/theater")
public class TheaterController {
	
	@GetMapping("/main")
	public String main() {
		
		return "/theater/main";
	}
}