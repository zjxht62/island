package com.zjx.island.utils.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * 客户端释放连接
 *
 * @author trevor.zhao
 * @date 2020/8/26
 */
public class ClientConnectionRelease {
    public final static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("https://www.baidu.com");

            System.out.println("Excuting request " + httpGet.getRequestLine());
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
                System.out.println("---------------------------");
                System.out.println(response.getStatusLine());

                //获取response entity;
                HttpEntity entity = response.getEntity();
                if (null != entity) {
                    InputStream inStream = entity.getContent();
                    try {
                        inStream.read();
                    } catch (IOException e) {
                        throw e;
                    } finally {
                        inStream.close();
                    }
                }
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }


    }
}
