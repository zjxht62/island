package com.zjx.island.utils.http;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/8/26
 */
public class MyHttpUtil {
    //默认字符集
    private static final Charset UTF_8 = StandardCharsets.UTF_8;


    private static final String CONTENT_TYPE_KEY = "Content-Type";
    private static final String AUTHORIZATION = "Authorization";
    private static final String APPLICATION = "application/json";
    private static final String APPLICATION_XML = "application/xml";
    private static final String INVOKECHANNEL = "invokeChannel";
    private static final String MOBILE = "mobile";
    private static final String ISDINGTALK = "isDingTalk";
    private static final String TRUE = "true";
    private static final String APPCODE = "APPCODE";

    public static String doPostBase(String url, Map<String, String> headerMap, String body) throws IOException {
        //创建httpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建httpPost
        HttpPost httpPost = new HttpPost(url);
        //设置headers
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpPost.setHeader(entry.getKey(), entry.getValue());
        }
        //设置请求实体
        StringEntity stringEntity = new StringEntity(body, UTF_8);
        httpPost.setEntity(stringEntity);
        //调用execute
        CloseableHttpResponse response = httpClient.execute(httpPost);

        try {
            System.out.println(response.getProtocolVersion());
            System.out.println(response.getStatusLine());
            //从返回中获取实体
            HttpEntity entity = response.getEntity();
            //返回报文
            return EntityUtils.toString(entity, UTF_8);
        } finally {
            response.close();
        }
    }

    public static String doPostStr(String url,String body) throws ParseException, IOException{
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put(CONTENT_TYPE_KEY, APPLICATION);
        return doPostBase(url,headerMap, body);

    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Map<String, String> headers = new HashMap<>();
        headers.put("invokeChannel", "mobile");
        headers.put("isDingTalk", "true");
        headers.put("Content-Type", "application/json");
        System.out.println(headers.entrySet());
        System.out.println(headers.keySet());
        URI uri = new URIBuilder()
            .setScheme("http")
            .setHost("10.0.0.6:8341")
            .setPath("/oms/webapi/oms/getLatestXmlDate")
            .build();
        System.out.println(doPostBase(uri.toString(), headers, "{\"scenesId\":37}"));
    }

}
