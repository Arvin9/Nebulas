package site.nebulas.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import site.nebulas.entity.Menu;
import site.nebulas.service.DailySentenceService;
import site.nebulas.service.MenuService;



@Controller
public class treeviewController {
	private Logger logger = LoggerFactory.getLogger(treeviewController.class);
	
	@Resource 
	private MenuService menuService; 
	
	
	@RequestMapping("treeview")
	public ModelAndView treeview(){
		ModelAndView modelAndView = new ModelAndView("treeview");
		return modelAndView;
	}
	

	
}
