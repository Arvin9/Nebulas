package site.nebulas.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import site.nebulas.entity.File;
import site.nebulas.service.DailySentenceService;
import site.nebulas.service.FileService;
import site.nebulas.util.DateUtil;



@Controller
public class uploadController {
	private Logger logger = LoggerFactory.getLogger(uploadController.class);
	
	
	@Resource 
	private FileService fileService;
	
	
	@RequestMapping("/fineUploader")
	public String fineUploader(){
		
		logger.debug("fineUploader debug");
		
		return "fineUploader";
	}
	
	@RequestMapping("/upload")
	public String upload(){
		
		logger.debug("upload debug");
		
		return "upload";
	}
	
	@RequestMapping("/uploadFile")
	public String uploadFile(@RequestParam("uploadFile")MultipartFile uploadFile) throws IOException{
		File file = new File();
		
		if (uploadFile!=null&&!uploadFile.isEmpty()) {
			file.setFileName(uploadFile.getOriginalFilename());
			file.setFileType(uploadFile.getContentType());
			file.setFileSize(uploadFile.getSize());
			//file.setFielContent();
			InputStream input = uploadFile.getInputStream();
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int n = 0;
			    while (-1 != (n = input.read(buffer))) {
			        output.write(buffer, 0, n);
			    }
			file.setFielContent(output.toByteArray());
			file.setAddTime(DateUtil.getSysdate(DateUtil.TYPE_DATETIME));    
			logger.info("uploadFileName:"+file.getFileName());
			logger.info("uploadFileType:"+file.getFileType());
			logger.info("uploadFileSize:"+file.getFileSize());
			
			try {
				System.out.println(uploadFile.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fileService.insert(file);
		}
		logger.debug("uploadFile debug");
		
		return "upload";
	}
	
	 
	@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次  
	public void myTest(){  
		System.out.println("进入测试");  
	}  
	
}
