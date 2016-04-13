package site.nebulas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("hello");
		return "hellomvc";
	}
}
