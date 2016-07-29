package site.nebulas.util.tuling;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import site.nebulas.util.tuling.util.Aes;
import site.nebulas.util.tuling.util.Md5;
import site.nebulas.util.tuling.util.PostServer;


/**
 * 加密请求测试类
 * @author 图灵机器人
 *
 */
public class AesTest {
	
	@Test
	public static void testAes(){
		//图灵网站上的secret
		String secret = "5b56794e4fa74a53";
		//图灵网站上的apiKey
		String apiKey = "72307a3ae94c424381b2a023a9df3520";
		String cmd = "你会什么";//测试用例
		//待加密的json数据
		String data = "{\"key\":\""+apiKey+"\",\"info\":\""+cmd+"\"}";
		//获取时间戳
		String timestamp = String.valueOf(System.currentTimeMillis());
		
		//生成密钥
		String keyParam = secret+timestamp+apiKey;
		String key = Md5.MD5(keyParam);
		
		//加密
		Aes mc = new Aes(key);
		data = mc.encrypt(data);		
		
		//封装请求参数
		JSONObject json = new JSONObject();
		json.put("key", apiKey);
		json.put("timestamp", timestamp);
		json.put("data", data);
		//请求图灵api
		String result = PostServer.SendPost(json.toString(), "http://www.tuling123.com/openapi/api");
		System.out.println(result);
	}
	public static void main(String[] args) {
		testAes();
	}
	
}