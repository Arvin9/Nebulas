package site.nebulas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class helloController {
	private Logger logger = LoggerFactory.getLogger(helloController.class);
	
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("hello");
		
		logger.debug("helllo debug");
		
		return "hellomvc";
	}
}
