package com.woori.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FridgeController {
	@GetMapping("/my_fridge")
	public String my_fridge() {
		return "my_fridge";
	}
}
