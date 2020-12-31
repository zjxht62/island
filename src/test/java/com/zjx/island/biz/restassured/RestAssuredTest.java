package com.zjx.island.biz.restassured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
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
    public int anInt  = 1;

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
            .when().post("http://10.0.0.3:8341/eTrust/microLogin");
        System.out.println(response.body().print());
        response.then().assertThat().body("success", equalTo(true));


    }
}
