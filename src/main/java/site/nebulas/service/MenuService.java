package site.nebulas.service;

import java.util.List;
import com.amazonaws.util.json.JSONObject;
import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONException;

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
	 * @see 查询menu_list将其封装成menu树，当前仅仅适用于二层树 
	 * @param 
	 * @return menu树json
	 * @exception 
	 * @override 
	 * 
	 * */
	
	public String getMenuByParm(Menu menu){
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONArray jsonArray2 = new JSONArray();
		List<Menu> menuList =  menuDao.getMenuByParm(null);
		
		try {
			int i = 1;
			for(Menu m : menuList){
				if(m.getParentID() == 1){					
					for(Menu mm : menuList){
						if(mm.getParentID() == m.getMenuID()){
							jsonArray2.put(new JSONObject(mm));
						}				
					}
					jsonArray.put(new JSONObject(m).accumulate("children",jsonArray2));
					jsonArray2 = null;
					i++;
				}	
			}
			jsonObject.append("menu", jsonArray);
			
			logger.info(jsonObject.toString());
		} catch (JSONException e) {
			logger.error("json封装异常");
			e.printStackTrace();
		}
		
		
		return jsonObject.toString();	
	}
}
