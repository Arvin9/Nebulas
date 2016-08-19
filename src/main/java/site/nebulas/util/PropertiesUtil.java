package site.nebulas.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public  class PropertiesUtil {
	
	/**
	 * 读取配置文件，分装成map 
	 * 
	 **/
	private static Map<String,String> getProperties() {
		InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("properties"+File.separator+"test.properties");   
		  Properties p = new Properties();
		  Map<String,String> map = new HashMap<String,String>();
		  try {   
		   p.load(inputStream);
		   for(Object key : p.keySet()){
			   map.put((String)key, p.getProperty((String)key));
		   }
		  } catch (IOException e1) {   
		   e1.printStackTrace();   
		  }   
		return map;
	}
	
	public static void main(String[] args) {
		Map<String,String> map = getProperties();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
