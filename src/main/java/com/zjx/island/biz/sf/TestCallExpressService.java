package com.zjx.island.biz.sf;

import java.io.FileInputStream;
import java.io.InputStream;
import com.sf.csim.express.service.CallExpressServiceTools;

public class TestCallExpressService {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        String reqXml = "<Request service='RouteService' lang='zh-CN'>\n" +
            "<Head>SLKJ2019</Head>\n" +
            "<Body>\n" +
            "<RouteRequest\n" +
            "tracking_type='1'\n" +
            "method_type='1'\n" +
            "tracking_number='438586741123'/>\n" +
            "</Body>\n" +
            "</Request>";
        /*
        try{
            @SuppressWarnings("resource")
            InputStream is = new FileInputStream("1.order.txt");//下订单
            //     InputStream is = new FileInputStream("2.order_query.txt");//查订单
            //     InputStream is = new FileInputStream("3.order_confirm.txt");//订单取消
            //     InputStream is = new FileInputStream("4.order_filter.txt");//订单筛选
            //	 InputStream is = new FileInputStream("5.route_queryByMailNo.txt");//路由查询-通过运单号
            //     InputStream is = new FileInputStream("5.route_queryByOrderNo.txt");//路由查询-通过订单号
            //     InputStream is = new FileInputStream("7.orderZD.txt");  //子单号申请
            byte[] bs = new byte[is.available()];
            is.read(bs);
            reqXml = "<Request service=\"OrderService\" lang=\"zh-CN\">\n" +
                "<Head>SLKJ2019</Head> \n" +
                "<Body> \n" +
                "\t<Order \n" +
                "\t          orderid=\"QIAO-20180104001\" \n" +
                "    \t          express_type='1' \n" +
                "                  j_province='广东省'\n" +
                "                  j_city='深圳市'  \n" +
                "                  j_company='顺丰镖局'\n" +
                "                  j_contact='虾哥'\n" +
                "                  j_tel='15012345678'\n" +
                "                  j_address='福田区新洲十一街万基商务大厦26楼'              \n" +
                "                  d_province='广东省' \n" +
                "\t\t\t   d_city='广州市' \n" +
                "\t\t\t   d_county=''\n" +
                "\t\t\t   d_company='神罗科技' \n" +
                "\t\t\t   d_contact='风一样的旭哥' \n" +
                "\t\t\t   d_tel='33992159' \n" +
                "\t\t\t   d_address='海珠区宝芝林大厦701室'  \n" +
                "                  parcel_quantity='1' \n" +
                "                  pay_method='3'\n" +
                "                  custid ='7551234567'  \n" +
                "                  customs_batchs=''\n" +
                "                   cargo='iphone 7 plus' >\n" +
                "\t\t\t    <AddedService name='COD' value='1.01' value1='7551234567'/>                                                                                                                                                           \n" +
                "         </Order>\n" +
                "</Body> \n" +
                "</Request>";
//            reqXml = new String(bs);


        }catch(Exception e){

        }
        */

        //丰桥平台公共测试账号
        //SLKJ2019
        //FBIqMkZjzxbsZgo7jTpeq7PD8CVzLT4Q
        String reqURL="";
        String clientCode="";//此处替换为您在丰桥平台获取的顾客编码
        String checkword="";//此处替换为您在丰桥平台获取的校验码
        CallExpressServiceTools client=CallExpressServiceTools.getInstance();
        String myReqXML=reqXml.replace("SLKJ2019",clientCode);
        System.out.println("请求报文："+myReqXML);
        String respXml= client.callSfExpressServiceByCSIM(reqURL, myReqXML, clientCode, checkword);

        if (respXml != null) {
            System.out.println("--------------------------------------");
            System.out.println("返回报文: "+ respXml);
            System.out.println("--------------------------------------");
        }
    }

    /*********************标准返回报文参考*****************************/
    //1.下订单-请求返回结果
    // <?xml version='1.0' encoding='UTF-8'?><Response service="OrderService"><Head>OK</Head><Body><OrderResponse filter_result="2" destcode="020" mailno="444000010085" origincode="755" orderid="QIAO-20171017001"/></Body></Response>


    //2.订单结果查询 -请求返回结果
    //<?xml version='1.0' encoding='UTF-8'?><Response service="OrderSearchService"><Head>OK</Head><Body><OrderResponse filter_result="2" destcode="020" mailno="444000010085,819000008006,819000008015" origincode="755" orderid="QIAO-20171017001"/></Body></Response>


    //3.订单取消-请求返回结果
    // <?xml version='1.0' encoding='UTF-8'?><Response service="OrderConfirmService"><Head>OK</Head><Body><OrderConfirmResponse res_status="2" orderid="QIAO-20171017001"/></Body></Response>

    //4.订单筛选-请求返回结果
    // <?xml version='1.0' encoding='UTF-8'?><Response service="OrderFilterService"><Head>OK</Head><Body><OrderFilterResponse filter_result="1" orderid="QIAO-20171017001"/></Body></Response>

    //5.路由查询-请求返回结果
    // <?xml version='1.0' encoding='UTF-8'?><Response service="RouteService"><Head>OK</Head><Body><RouteResponse mailno="444000010085" orderid="QIAO-20171017001"><Route remark="已经收件" accept_time="2017-08-31 02:01:44" accept_address="广东省深圳市软件产业基地" opcode="50"/><Route remark="已经收件" accept_time="2017-08-31 02:01:44" accept_address="广东省深圳市软件产业基地" opcode="80"/></RouteResponse></Body></Response>

    //6.路由推送

    //7.子单号申请-请求返回结果
    //<?xml version='1.0' encoding='UTF-8'?><Response service="OrderZDService"><Head>OK</Head><Body><OrderZDResponse><OrderZDResponse main_mailno="444000010085" mailno_zd="819000008006,819000008015" orderid="QIAO-20171017001"/></OrderZDResponse></Body></Response>



}
