package site.nebulas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import site.nebulas.entity.Manager;
import site.nebulas.entity.Menu;
import site.nebulas.entity.Role;
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
	
	@RequestMapping("signIn")
	public ModelAndView signIn(){
		ModelAndView modelAndView = new ModelAndView("signIn");
		return modelAndView;
	}
	
	@RequestMapping("login")
	public String  login(Model model,String userName,String password){
		Map<String,String> map = new HashMap<String,String>();
		System.out.println(userName+"  "+password);
		Manager manager = new Manager();
		manager.setManagerAccount(userName);
		List<Map<String, Object>>  managerList= menuService.getManageByParm(manager);
		System.out.println(managerList.toString());
		if(null == managerList || managerList.size() < 1){
			model.addAttribute("message", "no");
			System.out.println("无此用户");
			return "signIn";
		}else{
			if(password.equals(managerList.get(0).get("password"))){
				model.addAttribute("roleId", managerList.get(0).get("roleId").toString());
				return"menu";
			}else{
				model.addAttribute("message", "error");
				System.out.println("密码错误");
				return "signIn";
			}
			
		}
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
		List<Map<String,Object>> roleList = menuService.getRoleByParm(null);
		Map<String,Object> roleMap = new HashMap<String,Object>();
		
		for(Map<String,Object> map : roleList){
			roleMap.put(map.get("roleId").toString(), map.get("roleName"));
		}
		
		
		System.out.println(roleMap);
		modelAndView.addObject("roleMap",roleMap);
		return modelAndView;
	}
	
	
	
	
	@RequestMapping("queryMenu")
	@ResponseBody
	public Object queryMenu(Integer roleId){
		return menuService.getMenuByParm(roleId);
	}
	
	@RequestMapping("queryMenuEdit")
	@ResponseBody
	public Object queryMenuEdit(Integer roleId){
		return menuService.getMenuEditByParm(roleId);
	}
	
	@RequestMapping("updateMenu")
	@ResponseBody
	public String updateMenu(Menu menu){
		menuService.updateMenu(menu);
		return "success";
	}
	
	@RequestMapping("insertMenu")
	@ResponseBody
	public String insertMenu(Menu menu){
		menuService.insertMenu(menu);
		return "success";
	}
	
	@RequestMapping("queryManage")
	@ResponseBody
	public Object queryManage(Manager manager){
		return menuService.getManageByParm(manager);
	}
	
	@RequestMapping("updateManage")
	@ResponseBody
	public String updateManage(Manager manager){
		menuService.updateManage(manager);
		return "success";
	}
	@RequestMapping("insertManage")
	@ResponseBody
	public String insertManage(Manager manager){
		menuService.insertManage(manager);
		return "success";
	}
	
	@RequestMapping("queryRole")
	@ResponseBody
	public Object queryRole(Role role){
		return menuService.getRoleByParm(role);
	}
	@RequestMapping("updateRole")
	@ResponseBody
	public String updateRole(Role role){
		menuService.updateRole(role);
		return "success";
	}
	@RequestMapping("insertRole")
	@ResponseBody
	public String insertRole(Role role){
		menuService.insertRole(role);
		return "success";
	}
}
