package site.nebulas.controller;

import javax.annotation.Resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.nebulas.service.DailySentenceService;



@Controller
public class helloController {
	private Logger logger = LoggerFactory.getLogger(helloController.class);
	
	@Resource 
	private DailySentenceService dailySentenceService; 
	
	
	@RequestMapping("/hello")
	public String hello(){
		
		logger.info("hello");
		return "hellomvc";
	}
	@RequestMapping("serviceRobot")
	public String serviceRobot(){
		return "serviceRobot";
	}
	
	 
	@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次  
	public void myTest(){  
		System.out.println("进入测试");  
	}  
	
	@RequestMapping(value="askRobot",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String askRobot(String message){
		return site.nebulas.util.tuling.serviceRobot.askRobot(message);
	}
	
}
