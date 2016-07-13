package site.nebulas.dao;

import java.util.List;

import site.nebulas.entity.Menu;

public interface MenuDao {
	public List<Menu> getMenuByParm(Menu menu);
}
