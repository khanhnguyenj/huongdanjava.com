package com.huongdanjava.springbootdevtools;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {

		model.addAttribute("text", "Huong Dan Java - Spring Boot DevTools LiveReload example");

		return "home";
	}
}
