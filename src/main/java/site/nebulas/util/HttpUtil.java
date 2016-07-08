package site.nebulas.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	private static HttpClient httpClient;
	public static HttpClient getHttpClient() {
		if (httpClient==null) {
			Builder builder = RequestConfig.custom()
				    .setSocketTimeout(1000)
				    .setConnectTimeout(3000);
			RequestConfig config = builder.build();
			//指点该httpget的cofig;也可以通过下面指点client的config来实现；
			//httpGet.setConfig(config);
			//根据builder创建制定的client;
			HttpClientBuilder builder2 = HttpClients.custom().setDefaultRequestConfig(config);
			httpClient = builder2.build();
			return httpClient;
		}else{
			return httpClient;
		}
		
	}
	
	public static String doGet(String url) {
		//String url =  "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionProvince?";
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("Authorization", "WzV6YQLzShiESxk-H1ZN");
		String result = "";
		//创建默认的httpclient;
		//HttpClient httpClient = HttpClients.createDefault();
		try {
			HttpResponse httpResponse = getHttpClient().execute(httpGet);
			result = printResponse(httpResponse);
			httpResponse = null;
		} catch (Exception e) {
			logger.error("httpGet err :", e);
		}
		httpGet = null;
		return result;
	}
	/**
	 * 简单的post请求
	* @author Huangsp
	* @date 2015年1月23日 
	*
	 */
	public static String doPost(String url,Map<String, String> postParams) {
		String result = "";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		if(postParams!=null){
			for (String key:postParams.keySet()) {
				params.add(new BasicNameValuePair(key, postParams.get(key)));
			}
		}
		HttpPost httpPost = new HttpPost(url);
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8);
		entity.setContentType("application/x-www-form-urlencoded;charset=utf-8");
		httpPost.setEntity(entity);
		//HttpClient httpClient = HttpClients.createDefault();
		//设置redirect策略；
		LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
		CloseableHttpClient httpClient = HttpClients.custom()
		        .setRedirectStrategy(redirectStrategy)
		        .build();
		try {
			HttpResponse response = httpClient.execute(httpPost);
			result = printResponse(response);
		} catch (Exception e) {
			logger.error("httpPost err :", e);
		}
		httpPost = null;
		return result;
	}
	
	
	public static String printResponse(HttpResponse httpResponse) {
		String result = "";
		StatusLine line = httpResponse.getStatusLine();
		logger.debug(line.toString());
		Header[] headers = httpResponse.getAllHeaders();
		for (Header header : headers) {
			logger.debug(header.getName()+"  :  "+header.getValue());
		}
		logger.debug("================header end==========");
		logger.debug("================body==========");
		try {
			HttpEntity entity = httpResponse.getEntity();
			long len = entity.getContentLength();
			if (len!=-1 || len<2048) {
				logger.debug("使用EntityUtils..."+len);
				result = EntityUtils.toString(entity);
				logger.debug(result);
			}else{
				logger.debug("entity长度过长使用inputstream...."+len);
				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
				StringBuffer sb = new StringBuffer();
				String s = "";
				while((s=reader.readLine())!=null) {
					System.out.println(s);
					sb.append(s);
				}
				result = sb.toString();
			}
		} catch (Exception e) {
			logger.error("printResponse err :", e);
		}
		logger.debug("================body end==========");
		return result;
	}

	public static void main(String[] args) {
		HttpUtil httpUtil = new HttpUtil();
//		for (int i = 0; i <5000; i++) {
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					HttpUtil.doGet("http://localhost/testCharts.do");
//				}
//			}).start();
//		}
		System.out.println(HttpUtil.doGet("http://open.99yee.cn/api/supported_languages.json"));
	}
	
	
}
