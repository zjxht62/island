package com.zjx.island.utils;

import com.zjx.island.model.OrderModel;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/1/17
 */
public class HTMLUtil {
    public static String getSource(String url) {
        String html = new String();
        HttpGet httpget = new HttpGet(url);     //创建Http请求实例，URL 如：https://cd.lianjia.com/
        // 模拟浏览器，避免被服务器拒绝，返回返回403 forbidden的错误信息
        httpget.setHeader("User-Agent",
            "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");

        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();   // 使用默认的HttpClient
        try {
            response = httpclient.execute(httpget);
            if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {     // 返回 200 表示成功
                html = EntityUtils.toString(response.getEntity(), "utf-8");     // 获取服务器响应实体的内容
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return html;
    }

    public static Document getDocument(String html) {
        return Jsoup.parse(html);
    }

    public static List<String> getAviliableTime(Document document) {
        Elements times = document.getElementsByClass("a-date");
        List<String> aviliableTimeStringList = new ArrayList<>();
        for (Element time : times) {
            String aviliableTime = time.html();
            aviliableTimeStringList.add(aviliableTime);
        }
        return aviliableTimeStringList;
    }

    public static OrderModel hasAviliableTime(List<String> aviliableTimeStringList) {

        OrderModel orderModel = new OrderModel();
        for (int i = 0; i < aviliableTimeStringList.size(); i++){
            System.out.println(aviliableTimeStringList.get(i));
            if (aviliableTimeStringList.get(i).contains("预约")) {
                orderModel.setAviliable(true);
                orderModel.setAviliableString(aviliableTimeStringList.get(i));
                break;
            } else {
//                System.out.println("发现可预约的时间");
                orderModel.setAviliableString("null");
                orderModel.setAviliable(false);
            }
        }
        return orderModel;
    }

//    public static void main(String[] args) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        Document document = Jsoup.parse(getSource("https://maoyan.com/cinema/149?poi=283722&movieId=345808"));
//        Elements elements = document.select(".show-list");
//        stringBuilder.append("掠食城市排片:\n");
//        for (Element element : elements) {
//            if (element.select(".movie-name:contains(死侍)").toString().length() != 0) {
//                for (int i = 0; i < element.select(".date-item").size(); i++) {
//                    String day = element.select(".date-item").get(i).html();
//                    if (day.contains("31")) {
//                        stringBuilder.append(day + "\n" + "  放映时间\n");
//                    } else {
//                        continue;
//                    }
////                    Elements times = element.select("tbody").get(i).select(".begin-time");
////                    for (Element time : times) {
////                        stringBuilder.append("    " + time.html() + "\n");
////                    }
//                    Elements movieTimes = element.select("tbody");
//                    for (int j = 0; j < movieTimes.get(i).select(".begin-time").size(); j++) {
//                        stringBuilder.append(movieTimes.get(i).select(".begin-time").get(j).html() + "\n"
//                            + movieTimes.get(i).select(".end-time").get(j).html());
//                    }
//
//
//
//
//                    Elements beginTimes = element.select("tbody").get(i).select(".begin-time");
//                    Elements endTimes = element.select("tbody").get(i).select(".end-time");
//                    for (Element beginTime : beginTimes) {
//                        stringBuilder.append("    " + beginTime.html() + "\n");
//                    }
//                    for (Element endTime : endTimes) {
//                        stringBuilder.append("    " + endTime.html() + "\n");
//                    }
//                }
//
//            }
//        }
//        System.out.println(stringBuilder.toString());
////        System.out.println(elements);
////        System.out.println(document.select(".show-list .movie-name:contains(掠食城市)"));
//
//    }

    public static void main(String[] args) {
        Document document = getDocument("<option value=\"\">请选择行车方向</option><option value=\"4735093507032488486\">52(平乐园-靛厂新村)</option><option value=\"5576015467968999475\">52(靛厂新村-平乐园)</option>");
        Elements options = document.select("option");
        for (Element element : options) {
            System.out.println(element);
        }
    }
}
