package com.zjx.island.utils;

// 需要用户名密码邮件发送实例
//文件名 SendEmail2.java
//本实例以QQ邮箱为例，你需要在qq后台设置

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class EmailUtil {
    public static void send(String sendTo, String errorMessage, Boolean hasFile, String head) {
        // 收件人电子邮箱
        String to = sendTo;

        // 发件人电子邮箱
        String from = "";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", ""); //发件人邮件用户名、密码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象。
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(to));

            // Set Subject: 头字段
            message.setSubject(head);

            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();

            // 消息
            messageBodyPart.setText(errorMessage);


            // 创建多重消息
            Multipart multipart = new MimeMultipart();

            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);

            if (hasFile) {

                File directory = new File("");
//                System.out.println("当前地址" + directory.getAbsolutePath());//获取绝对路径

                // 附件部分图片
                BodyPart picAttachmentBodyPart = new MimeBodyPart();
                String picName = "errorPicture.png";
                DataSource picSource = new FileDataSource(directory.getAbsolutePath() + "/errorhappen.png");
                picAttachmentBodyPart.setDataHandler(new DataHandler(picSource));
                picAttachmentBodyPart.setFileName(picName);
                multipart.addBodyPart(picAttachmentBodyPart);


                // 附件部分图片
                BodyPart videoAttachmentBodyPart = new MimeBodyPart();
                String videoName = "errorVideo.mp4";
                DataSource videoSource = new FileDataSource(directory.getAbsolutePath() + "/demo.mp4");
                videoAttachmentBodyPart.setDataHandler(new DataHandler(videoSource));
                videoAttachmentBodyPart.setFileName(videoName);
                multipart.addBodyPart(videoAttachmentBodyPart);



            }

            // 发送完整消息
            message.setContent(multipart);

            //   发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}