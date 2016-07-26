package site.nebulas.dao;

import java.util.List;
import java.util.Map;

import site.nebulas.entity.Manager;
import site.nebulas.entity.Menu;

public interface MenuDao {
	public List<Map<String,Object>> getMenuByParm(Menu menu);
	public void insert(Menu menu);	
	public void update(Menu menu);
	public void delete(Menu menu);
	
	public List<Map<String,Object>> getManageByParm(Manager manager);
	
}
