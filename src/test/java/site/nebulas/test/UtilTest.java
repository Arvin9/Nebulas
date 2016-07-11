package site.nebulas.test;


import site.nebulas.util.HttpUtil;

public class UtilTest {
	public static void main(String[] args) {

		
		System.out.println(HttpUtil.doGet("http://open.99yee.cn/api/jobs/:uuid.json='1747370C-44B4-11E6-B116-0242AC110003'"));
	}
	
}
