package site.nebulas.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import site.nebulas.entity.Mail;



/**
 * 邮件发送工具实现类
 * 
 * @author Nebula
 * @create 2016/4/24
 */
public class MailUtil {
	public boolean send(String message) {
		// 发送email
		//设置mail信息
		Mail mail = new Mail();
		
		mail.setHost("smtp.163.com"); // 设置邮件服务器
		mail.setSender("arvin_fj@163.com");
		
		mail.setReceiver("594113869@qq.com"); // 接收人
		
		mail.setUsername("arvin_fj@163.com"); // 登录账号,一般都是和邮箱名一样吧
		
		mail.setPassword("flxpdkbukjonbbah"); // 发件人邮箱的登录密码
		mail.setSubject("Contact");//邮件主题
		mail.setMessage(message);
		
		try {
			HtmlEmail email = new HtmlEmail();
			
			// 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
			email.setHostName(mail.getHost());
			// 字符编码集的设置
			email.setCharset(Mail.ENCODEING);
			// 收件人的邮箱
			email.addTo(mail.getReceiver());
			// 发送人的邮箱
			email.setFrom(mail.getSender(), mail.getName());
			// 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
			email.setAuthentication(mail.getUsername(), mail.getPassword());
			// 要发送的邮件主题
			email.setSubject(mail.getSubject());
			// 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
			email.setMsg(mail.getMessage());
			// 发送
			email.send();

			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			return false;
		}
	}
}
