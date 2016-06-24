package site.nebulas.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import site.nebulas.service.DailySentenceService;



@Controller
public class helloController {
	private Logger logger = LoggerFactory.getLogger(helloController.class);
	
	@Resource 
	private DailySentenceService dailySentenceService;
	
	
	@RequestMapping("/hello")
	public String hello(){
		System.out.println(dailySentenceService.getDailySentenceByParm(null).get(0).getSentence());
		System.out.println(dailySentenceService.getDailySentenceByParm(null).size());
		logger.debug(dailySentenceService.getDailySentenceByParm(null).toString());
		logger.debug("helllo debug");
		
		return "hellomvc";
	}
	
	 
	@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次  
	public void myTest(){  
		System.out.println("进入测试");  
	}  
	
}
