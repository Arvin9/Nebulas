package site.nebulas.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import site.nebulas.entity.EmailMessage;
import site.nebulas.service.SendMailService;





@Controller
public class SendMailController {
	
	@Resource
	private SendMailService sendMailService;
	
	
	@RequestMapping("/sendMail")
	public String sendMail(EmailMessage emailMessage){
		
		sendMailService.sendMail(emailMessage);
		

		return "contact";
	}
	
	
}
