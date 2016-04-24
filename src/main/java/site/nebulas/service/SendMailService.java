package site.nebulas.service;

import org.springframework.stereotype.Service;

import site.nebulas.entity.EmailMessage;
import site.nebulas.util.MailUtil;


@Service
public class SendMailService {
	private String messages;
	private String name;
	private String mail;
	private String subject;
	private String message;
	public String  sendMail(EmailMessage emailMessage){
		messages = "";
		emailMessage.getName();
		name = emailMessage.getName();
		mail = emailMessage.getEmail();
		subject = emailMessage.getSubject();
		message = emailMessage.getMessage();
		if (name != null && mail != null && subject != null && message != null){
		
			messages += "Name:" + name + "\n";
			messages += "Mail:"+mail+"\n";
			messages += "Subject:"+ subject +"\n";		
			messages += "Message:"+ message +"\n";
			new MailUtil().send(messages);
			return "send_success";
		}
		return "send_fail";
	
	}
}
