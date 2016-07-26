package site.nebulas.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.nebulas.dao.MenuDao;
import site.nebulas.entity.Manager;
import site.nebulas.entity.Menu;
@Service
public class MenuService {
	@Resource
	private MenuDao menuDao;
	
	private Logger logger = LoggerFactory.getLogger(MenuService.class);
	
	
	/*
	 * @author CaiHonghui
	 * @version 
	 * @see
	 * @param 
	 * @return menu树json
	 * @exception 
	 * @override 
	 * 
	 * */
	
	public List<Map<String,Object>> getMenuByParm(Menu menu){
		List<Map<String,Object>> list = menuDao.getMenuByParm(menu);
		for(Map<String,Object> map : list){
			map.put("target", "_self");
			map.put("open", "true");
		}
		return list;	
	}
	public List<Map<String,Object>> getManageByParm(Manager manager){
		return menuDao.getManageByParm(manager);
	}
	
	
	public void insert(Menu menu){
		menuDao.insert(menu);
	}
	
	public void update(Menu menu){
		menuDao.update(menu);
	}
	
	public void delete(Menu menu){
		menuDao.delete(menu);
	}
}
