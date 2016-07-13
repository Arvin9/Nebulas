package site.nebulas.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import site.nebulas.service.DailySentenceService;
import site.nebulas.service.MenuService;



@Controller
public class menuController {
	private Logger logger = LoggerFactory.getLogger(menuController.class);
	
	@Resource 
	private MenuService menuService; 
	
	
	@RequestMapping("menu")
	public ModelAndView menu(){
		ModelAndView modelAndView = new ModelAndView("menu");
		modelAndView.addObject("menuTree", menuService.getMenuByParm(null));
		logger.info(menuService.getMenuByParm(null));
		
		return modelAndView;
	}
	
}
