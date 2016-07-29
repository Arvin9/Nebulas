package site.nebulas.dao;

import java.util.List;
import java.util.Map;

import site.nebulas.entity.Manager;
import site.nebulas.entity.Menu;
import site.nebulas.entity.Role;

public interface MenuDao {
	public List<Map<String,Object>> getMenuByParm(Integer roleId);
	public void insertMenu(Menu menu);	
	public void updateMenu(Menu menu);
	public void delete(Menu menu);
	
	public List<Map<String,Object>> getManageByParm(Manager manager);
	public void updateManage(Manager manager);
	public void insertManage(Manager manager);
	
	public List<Map<String,Object>> getRoleByParm(Role role);
	public void updateRole(Role role);
	public void insertRole(Role role);	
	
	
	
}
