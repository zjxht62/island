package com.zjx.island.biz.restassured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/12/31
 */
public class RestAssuredTest {
    public static Headers HEADERS;

    @BeforeClass
    public static void addHeader() {
        Header isDing = new Header("isDingTalk","true");
        Header invokeChannel = new Header("invokeChannel", "mobile");
        Header contentType = new Header("Content-Type", "application/json");
        HEADERS = new Headers(isDing, invokeChannel, contentType);
    }

    @Test
    public void test() {
        System.out.println(HEADERS.toString());
        Response response = given().body("{\"data\":{\"loginName\":\"13241336315\",\"loginPassword\":\"7cc2cf8a95f80a8ea500ff997f9623e4\"},\"host\":\"https://sit-www.trustlife.com\",\"environmentCode\":0}")
//            .contentType(ContentType.JSON)
            .headers(HEADERS)
            .when().post("http://10.0.0.3:8341/eTrust/microLogin")

            .then()
            //assertThat是语法糖
            .assertThat().statusCode(200)
            .assertThat().body("success", equalTo(true))
            .assertThat().body("resultMsg", equalTo("操作成功"))

//              提取单个值
//            .extract().path();

            //提取多个值,可以返回response
        .extract()
            .response();
        Boolean resultMsg = response.path("success");
        String errorCode = response.path("errorCode");
        String data = response.path("data");
        System.out.println(resultMsg);
        System.out.println(errorCode);
        System.out.println(data);


        //单独使用JsonPath解析返回
        JsonPath jsonPath = new JsonPath(data);
        //比如出返回报文里的authToken
        String authToken = jsonPath.getString("data.token.authToken");
//        List<Integer> winnerIds = jsonPath.get("winners.winnderId");
        System.out.println(authToken);



    }
}
