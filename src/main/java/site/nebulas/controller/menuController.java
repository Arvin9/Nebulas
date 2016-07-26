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

import site.nebulas.entity.Manager;
import site.nebulas.entity.Menu;
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
		return modelAndView;
	}
	
	
	@RequestMapping("editMenu")
	public ModelAndView editMenu(){
		ModelAndView modelAndView = new ModelAndView("editMenu");
		return modelAndView;
	}
	
	@RequestMapping("roleManage")
	public ModelAndView roleManage(){
		ModelAndView modelAndView = new ModelAndView("roleManage");
		return modelAndView;
	}
	@RequestMapping("menuManage")
	public ModelAndView menuManage(){
		ModelAndView modelAndView = new ModelAndView("menuManage");
		return modelAndView;
	}
	@RequestMapping("userManage")
	public ModelAndView userManage(){
		ModelAndView modelAndView = new ModelAndView("userManage");
		return modelAndView;
	}
	
	
	
	
	@RequestMapping("queryMenu")
	@ResponseBody
	public Object queryMenu(Menu menu){
		logger.info(menuService.getMenuByParm(menu).toString());
		return menuService.getMenuByParm(menu);
	}
	@RequestMapping("updateMenu")
	@ResponseBody
	public void updateMenu(Menu menu){
		menuService.update(menu);
	}
	@RequestMapping("deleteMenu")
	@ResponseBody
	public void deleteMenu(Menu menu){
		menuService.delete(menu);
	}
	@RequestMapping("queryRole")
	@ResponseBody
	public Object queryRole(Menu menu){
		logger.info(menuService.getMenuByParm(menu).toString());
		return menuService.getMenuByParm(menu);
	}
	
	@RequestMapping("queryManage")
	@ResponseBody
	public Object queryManage(Manager manager){
		logger.info(menuService.getManageByParm(manager).toString());
		return menuService.getManageByParm(manager);
	}
	
}
