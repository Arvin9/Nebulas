package site.nebulas.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.HttpParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import site.nebulas.entity.File;
import site.nebulas.service.DailySentenceService;
import site.nebulas.service.FileService;
import site.nebulas.util.DateUtil;
import site.nebulas.util.Encodes;
import site.nebulas.util.HttpUtil;



@Controller
public class uploadController {
	private Logger logger = LoggerFactory.getLogger(uploadController.class);
	
	
	@Resource 
	private FileService fileService;
	
	
	@RequestMapping("/fineUploader")
	public ModelAndView fineUploader(){
		ModelAndView modelAndView = new ModelAndView("fineUploader");
		logger.debug("fineUploader debug");
		
		return modelAndView;
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
			
			InputStream input = uploadFile.getInputStream();
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int n = 0;
			while (-1 != (n = input.read(buffer))) {
				output.write(buffer, 0, n);
			}
			//上传翻译任务
			
			String contentBase64 = Encodes.encodeBase64(output.toByteArray());
			
			
		
			
			file.setFielContent(output.toByteArray());
			file.setAddTime(DateUtil.getSysdate(DateUtil.TYPE_DATETIME));    
			logger.info("uploadFileName:"+file.getFileName());
			logger.info("uploadFileType:"+file.getFileType());
			logger.info("uploadFileSize:"+file.getFileSize());
			
			
			fileService.insert(file);
		}
		logger.debug("uploadFile debug");
		
		return "upload";
	}
	
	
	@RequestMapping("/fineUploadFile")
	@ResponseBody
	public Object fineUploadFile(@RequestParam("qqfile")MultipartFile uploadFile) throws IOException{
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
		file.setSuccess("true");
		return file;
	}
	
	 
	@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次  
	public void myTest(){  
		System.out.println("进入测试");  
	}  
	
}
