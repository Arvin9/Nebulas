package site.nebulas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class homeController {
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	@RequestMapping("/about")
	public String about(){
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contact(){
		return "contact";
	}
	
	@RequestMapping("/signIn")
	public String signIn(){
		return "signIn";
	}
}
