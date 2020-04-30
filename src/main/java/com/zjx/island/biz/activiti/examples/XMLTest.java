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
    public static String TEST_XML_STRING =
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Root>\n" +
            "  <Common>\n" +
            "    <SUB_COMPANY>2</SUB_COMPANY>\n" +
            "    <PRINT_NO></PRINT_NO>\n" +
            "    <TRADE_TIME>2020-03-23 13:03:40</TRADE_TIME>\n" +
            "    <DEAL_TYPE>3</DEAL_TYPE>\n" +
            "    <BRANCH_CODE>000000</BRANCH_CODE>\n" +
            "    <CHANNEL_CODE>0015</CHANNEL_CODE>\n" +
            "    <RISK_CODE>0000000002</RISK_CODE>\n" +
            "    <APPLICANT_NAME></APPLICANT_NAME>\n" +
            "    <CREDENTIAL_TYPE></CREDENTIAL_TYPE>\n" +
            "    <CREDENTIAL_NO></CREDENTIAL_NO>\n" +
            "    <PHONE_NO></PHONE_NO>\n" +
            "    <E_MAIL></E_MAIL>\n" +
            "    <SEND_TIME>2020-03-23 13:03:40</SEND_TIME>\n" +
            "    <IF_EMAIL>1</IF_EMAIL>\n" +
            "    <IF_RAR>0</IF_RAR>\n" +
            "    <IF_MESSAGE>0</IF_MESSAGE>\n" +
            "    <MUSTNEW>0</MUSTNEW>\n" +
            "    <QRYDLD_FLG>1</QRYDLD_FLG>\n" +
            "    <CANCEL_FLG>0</CANCEL_FLG>\n" +
            "    <SIGN>SM2</SIGN>\n" +
            "    <PASSWORD></PASSWORD>\n" +
            "  </Common>\n" +
            "  <Main>\n" +
            "    <Message></Message>\n" +
            "    <Email></Email>\n" +
            "    <FrontCover>NormalFrontCover.pdf</FrontCover>\n" +
            "    <BackCover>NormalBackCover.pdf</BackCover>\n" +
            "    <InsuredPersons>\n" +
            "      <InsuredPerson>\n" +
            "        <InsName>吴亦凡</InsName>\n" +
            "        <MemberId>0000052992</MemberId>\n" +
            "        <Birthday>1994-01-01</Birthday>\n" +
            "        <Sex>男</Sex>\n" +
            "        <Age>26周岁</Age>\n" +
            "        <Doc>身份证</Doc>\n" +
            "        <DocNo>110102199401010010</DocNo>\n" +
            "        <DocValidDate>2099-01-01</DocValidDate>\n" +
            "        <Job>参见投保时选择</Job>\n" +
            "        <Phone>16669890004</Phone>\n" +
            "        <Height>--</Height>\n" +
            "        <Weight>--</Weight>\n" +
            "        <ZipCode></ZipCode>\n" +
            "        <Mail>derek.liang@trustlife.com</Mail>\n" +
            "        <PostAddr>--</PostAddr>\n" +
            "        <Relation>本人</Relation>\n" +
            "        <Nationality>中国</Nationality>\n" +
            "        <TrafficAccidentInss>\n" +
            "          <TrafficAccidentIns>\n" +
            "            <InsType>信美相互i自由交通工具意外伤害保险</InsType>\n" +
            "            <ClauseTime>1年</ClauseTime>\n" +
            "            <InsuranceTime>2020年03月24日起至2021年03月23日止</InsuranceTime>\n" +
            "            <PayTime>年交</PayTime>\n" +
            "            <KeepTime>1年</KeepTime>\n" +
            "            <AutoRenewal>否</AutoRenewal>\n" +
            "            <InsuredLiabilitys>\n" +
            "              <InsuredLiability>\n" +
            "                <LiabilityName>公务车</LiabilityName>\n" +
            "                <BasicInsSum>100,000.00元</BasicInsSum>\n" +
            "                <InitialPremium>20.00元</InitialPremium>\n" +
            "              </InsuredLiability>\n" +
            "            </InsuredLiabilitys>\n" +
            "            <DieBfcyItemLegal>\n" +
            "              <DieBfcyItem>\n" +
            "                <DieBfcy>法定</DieBfcy>\n" +
            "              </DieBfcyItem>\n" +
            "            </DieBfcyItemLegal>\n" +
            "            <InsName>吴亦凡(会员号：0000052992)</InsName>\n" +
            "            <Sex>男</Sex>\n" +
            "            <Age>26周岁</Age>\n" +
            "          </TrafficAccidentIns>\n" +
            "        </TrafficAccidentInss>\n" +
            "        <OneYearCommonInss/>\n" +
            "        <CommonInss/>\n" +
            "        <EndowmentAnnuitys/>\n" +
            "        <ExistenceAnnuitys/>\n" +
            "        <SpecoalAgreement></SpecoalAgreement>\n" +
            "        <ResidentCountry>--</ResidentCountry>\n" +
            "      </InsuredPerson>\n" +
            "    </InsuredPersons>\n" +
            "    <InsConNO>1211520042765488</InsConNO>\n" +
            "    <ValidDate>2020年03月24日</ValidDate>\n" +
            "    <HesitatePeriod>10天</HesitatePeriod>\n" +
            "    <CurrentPermSum>20.00元</CurrentPermSum>\n" +
            "    <BillDate>2020年03月23日</BillDate>\n" +
            "    <SignTime>2020年03月23日</SignTime>\n" +
            "    <Chairman></Chairman>\n" +
            "    <Seal></Seal>\n" +
            "    <ApplyName>吴亦凡</ApplyName>\n" +
            "    <MemberId>0000052992</MemberId>\n" +
            "    <Birthday>1994-01-01</Birthday>\n" +
            "    <Sex>男</Sex>\n" +
            "    <Doc>身份证</Doc>\n" +
            "    <DocNO>110102199401010010</DocNO>\n" +
            "    <DocValidDate>2099-01-01</DocValidDate>\n" +
            "    <Job>参见投保时选择</Job>\n" +
            "    <Phone>16669890004</Phone>\n" +
            "    <Mail>derek.liang@trustlife.com</Mail>\n" +
            "    <PostAddr>--</PostAddr>\n" +
            "    <Age>26周岁</Age>\n" +
            "    <Nationality>中国</Nationality>\n" +
            "    <InitialPremium>20.00元</InitialPremium>\n" +
            "    <OneCaption>贰拾元整</OneCaption>\n" +
            "    <PayMethod>年交</PayMethod>\n" +
            "    <PayType>银行转账</PayType>\n" +
            "    <AutopayNotices>\n" +
            "      <AutopayNotice>\n" +
            "        <AccountName>吴亦凡</AccountName>\n" +
            "        <Account>6174200081238968071</Account>\n" +
            "        <BankName>中国建设银行</BankName>\n" +
            "        <BankAddress>北京市市辖区</BankAddress>\n" +
            "      </AutopayNotice>\n" +
            "    </AutopayNotices>\n" +
            "    <Statements>\n" +
            "      <Statement>\n" +
            "        <StatementContent>XXXX</StatementContent>\n" +
            "      </Statement>\n" +
            "    </Statements>\n" +
            "    <InsClause>IAMISTL02A12</InsClause>\n" +
            "    <Solvency>\n" +
            "      <Year>2020</Year>\n" +
            "      <AdequacyRatio>XXXXX</AdequacyRatio>\n" +
            "      <Number>xxx</Number>\n" +
            "      <SolvencyType>xxxxx</SolvencyType>\n" +
            "    </Solvency>\n" +
            "    <FirstPayMode>银行转账</FirstPayMode>\n" +
            "    <NextPayMode>银行转账</NextPayMode>\n" +
            "    <AgentBankName></AgentBankName>\n" +
            "    <AgentPersonCode>null/null</AgentPersonCode>\n" +
            "    <BankAutos/>\n" +
            "    <Firm>信美人寿相互保险社</Firm>\n" +
            "    <Site>北京市西城区宣武门西大街129号金隅大厦15层</Site>\n" +
            "    <Web>www.trustlife.com</Web>\n" +
            "    <CSTel>400-139-9990</CSTel>\n" +
            "    <Agree></Agree>\n" +
            "    <OneYearNoticeFlags>\n" +
            "      <OneYearNoticeFlag>\n" +
            "        <Content>自动续保</Content>\n" +
            "      </OneYearNoticeFlag>\n" +
            "    </OneYearNoticeFlags>\n" +
            "    <ShortAgreeFlags>\n" +
            "      <ShortAgreeFlag>\n" +
            "        <Content>无尊享期</Content>\n" +
            "      </ShortAgreeFlag>\n" +
            "    </ShortAgreeFlags>\n" +
            "    <NoCrsNoticeFlags>\n" +
            "      <NoCrsNoticeFlag>\n" +
            "        <Content>NoCRS</Content>\n" +
            "      </NoCrsNoticeFlag>\n" +
            "    </NoCrsNoticeFlags>\n" +
            "    <DieBfcyItemLegal>\n" +
            "      <DieBfcyItem>\n" +
            "        <DieBfcy>法定</DieBfcy>\n" +
            "      </DieBfcyItem>\n" +
            "    </DieBfcyItemLegal>\n" +
            "  </Main>\n" +
            "  <Pdfs>\n" +
            "    <Pdf>\n" +
            "      <Duplex>1</Duplex>\n" +
            "      <TagName>TagOne</TagName>\n" +
            "      <FromAppName>TIS</FromAppName>\n" +
            "      <ResType>Clauses</ResType>\n" +
            "      <ResName>001.pdf</ResName>\n" +
            "    </Pdf>\n" +
            "  </Pdfs>\n" +
            "  <MemberNotes>\n" +
            "    <MemberNote>\n" +
            "      <MemberNote>211</MemberNote>\n" +
            "    </MemberNote>\n" +
            "  </MemberNotes>\n" +
            "  <FirstReceipts>\n" +
            "    <FirstReceipt>\n" +
            "      <ReceiptNO>2020030103133864</ReceiptNO>\n" +
            "      <InsConNO>1211520042765488</InsConNO>\n" +
            "      <PersonName>吴亦凡</PersonName>\n" +
            "      <InsuredPersons>\n" +
            "        <InsuredPerson>\n" +
            "          <InsName>吴亦凡</InsName>\n" +
            "          <CoverageInfos>\n" +
            "            <CoverageInfo>\n" +
            "              <InsType>信美相互i自由交通工具意外伤害保险-公务车</InsType>\n" +
            "              <PayTime>年交</PayTime>\n" +
            "              <KeepTime>1年</KeepTime>\n" +
            "              <EachInsFee>20.00元</EachInsFee>\n" +
            "            </CoverageInfo>\n" +
            "          </CoverageInfos>\n" +
            "        </InsuredPerson>\n" +
            "      </InsuredPersons>\n" +
            "      <CurrentPermSum>20.00元</CurrentPermSum>\n" +
            "      <CurrentPermSumCapital>贰拾元整</CurrentPermSumCapital>\n" +
            "      <ChargeDate>2020年03月23日</ChargeDate>\n" +
            "    </FirstReceipt>\n" +
            "  </FirstReceipts>\n" +
            "  <ApplyFlags/>\n" +
            "</Root>";

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
