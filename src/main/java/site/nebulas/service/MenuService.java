package site.nebulas.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.nebulas.dao.MenuDao;
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
		return menuDao.getMenuByParm(menu);	
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
