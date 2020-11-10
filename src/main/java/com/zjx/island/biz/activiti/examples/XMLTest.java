package com.zjx.island.biz.activiti.examples;

import org.activiti.engine.impl.util.json.JSONObject;
import org.activiti.engine.impl.util.json.XML;
import org.json.JSONException;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/4/15
 */
public class XMLTest {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String TEST_XML_STRING = "";


    public static void main(String[] args) {
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
        } catch (Exception je) {
            System.out.println(je.toString());
        }
    }

}
