package com.zjx.island.utils.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 如何使用ResponseHandler来简化处理HTTP响应和释放相关资源的过程
 *
 * @author trevor.zhao
 * @date 2020/8/25
 */
public class ClientWithResponseHandler {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("https://www.baidu.com/");
            System.out.println("执行请求:" + httpGet.getRequestLine());

            //创建一个自定义response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                    int status = httpResponse.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = httpResponse.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexcepted response status:" + status);
                    }
                }
            };
            String responseBody = httpClient.execute(httpGet, responseHandler);
            System.out.println("----------------------------------");
            System.out.println(responseBody);
        } finally {
            httpClient.close();
        }


    }
}
