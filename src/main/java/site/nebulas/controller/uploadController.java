package site.nebulas.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import site.nebulas.service.DailySentenceService;



@Controller
public class uploadController {
	private Logger logger = LoggerFactory.getLogger(uploadController.class);
	
	@Resource 
	private DailySentenceService dailySentenceService;
	
	
	@RequestMapping("/upload")
	public String upload(){
		System.out.println(dailySentenceService.getDailySentenceByParm(null).get(0).getSentence());
		System.out.println(dailySentenceService.getDailySentenceByParm(null).size());
		logger.debug(dailySentenceService.getDailySentenceByParm(null).toString());
		logger.debug("helllo debug");
		
		return "upload";
	}
	
	@RequestMapping("/uploadFile")
	public String uploadFile(@RequestParam("uploadFile")MultipartFile uploadFile){
		if (uploadFile!=null&&!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			System.out.println("fileName:"+uploadFile.getOriginalFilename());
			try {
				System.out.println(uploadFile.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.debug("uploadFile debug");
		
		return "upload";
	}
	
	 
	@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次  
	public void myTest(){  
		System.out.println("进入测试");  
	}  
	
}
