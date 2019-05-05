package com.zjx.island.utils;

import com.zjx.island.misc.Constant;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HttpUWUtil {
	private static Logger logger = LoggerFactory.getLogger(HttpUWUtil.class);
    private static final String CONTENT_TYPE_KEY = "Content-Type";
    private static final String AUTHORIZATION = "Authorization";
    private static final String APPLICATION = "application/json";
	private static final String APPLICATION_XML = "application/xml";
	private static String CHARSET = "UTF-8";

	public static String doGetStrBase(String url,Map<String,String> headerMap) throws ParseException, IOException{
	    DefaultHttpClient client = new DefaultHttpClient();
	    HttpGet httpGet = new HttpGet(url);
		for (Map.Entry<String,String> entry : headerMap.entrySet()) {
			httpGet.addHeader(entry.getKey(),entry.getValue());
		}
	    HttpResponse httpResponse = client.execute(httpGet);
	    HttpEntity entity = httpResponse.getEntity();
	    String result = EntityUtils.toString(entity,CHARSET);
		// TODO: 2017/7/24  目前返回日志全部由各个方法打印
//		logger.info("result：" + result);
		return result;
	}

	public static String doPostBase(String url, String json, Map<String,String> headerMap) throws ParseException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		for (Map.Entry<String,String> entry : headerMap.entrySet()) {
			httpPost.addHeader(entry.getKey(),entry.getValue());
		}
		StringEntity entity = new StringEntity(json, CHARSET);
		httpPost.setEntity(entity);
		HttpResponse httpResponse = client.execute(httpPost);
		HttpEntity httpEntity = httpResponse.getEntity();
		String result = EntityUtils.toString(httpEntity,CHARSET);
		// TODO: 2017/7/24  目前返回日志全部由各个方法打印
//		logger.info("result：" + result);
		return result;
	}

	public static String doPostStr(String url,String json) throws ParseException, IOException{
		Map<String,String> headerMap = new HashMap<>();
		headerMap.put(CONTENT_TYPE_KEY, APPLICATION);
		return doPostBase(url,json,headerMap);
	}

	public static String doGetStrWithToken(String url,String auth) throws ParseException, IOException{
		Map<String,String> headerMap = new HashMap<>();
		headerMap.put(CONTENT_TYPE_KEY, APPLICATION);
		headerMap.put("authtoken", auth);
		return doGetStrBase(url,headerMap);
	}

	public static String doPostStrWithToken(String url,String json,String auth) throws ParseException, IOException{
		Map<String,String> headerMap = new HashMap<>();
		headerMap.put(CONTENT_TYPE_KEY, APPLICATION);
		headerMap.put("authtoken", auth);
		return doPostBase(url,json,headerMap);
	}

	public static String doPostWithAuth(String url,String json,String auth) throws ParseException, IOException{
		logger.info("HttpRequest url：" + url);
		logger.info("HttpRequest requestString：" + json);
		logger.info("HttpRequest auth：" + auth);
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader(CONTENT_TYPE_KEY, APPLICATION);
		httpPost.addHeader(AUTHORIZATION, auth);

		StringEntity entity = new StringEntity(json, CHARSET);
		httpPost.setEntity(entity);

		HttpResponse httpResponse = client.execute(httpPost);
		HttpEntity aaa = httpResponse.getEntity();
		String result = EntityUtils.toString(aaa,CHARSET);
		// TODO: 2017/7/24  目前返回日志全部由各个方法打印
//		logger.info("result：" + result);
		return result;
	}

	public static String doPostXmlStr(String url,String xml) throws ParseException, IOException{
		Map<String,String> headerMap = new HashMap<>();
		headerMap.put(CONTENT_TYPE_KEY, APPLICATION_XML);
		return doPostBase(url,xml,headerMap);
	}

	public static void main(String[] args) {
		try {
			doPostStr(Constant.url.ROBOT_URL, "{\"msgtype\": \"text\",\n" +
				"\"text\": {\n" +
				"\"content\": \"我是个莫得感情的机器人\"\n" +
				"},\n" +
				"\"at\": {\n" +
				"\"atMobiles\": [\n" +
				"\"13241336315\"\n" +
				"], \n" +
				"\"isAtAll\": false\n" +
				"}\n" +
				"}");
		}catch (Exception e) {

		}
	}

}
