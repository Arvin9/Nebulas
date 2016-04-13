package site.nebulas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class helloController {
	@RequestMapping("/mvc")
	public String hello(){
		System.out.println("hello");
		return "hellomvc";
	}
}
