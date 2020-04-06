package com.tianhongguoji.test.util;

import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.sun.mail.util.MailSSLSocketFactory;
/**
 * 名称： JavaMailUtils
 * 作者： zdt
 * 日期： 2020-04-04 15:38
 * 描述： 发邮件
 **/
public class JavaMailUtils {

    /**
     * 发送邮件工具类:通过qq邮件发送,因为具有ssl加密,采用的是smtp协议
     * @param mailServer 邮件服务器的主机名:如 "smtp.qq.com"
     * @param loginAccount 登录邮箱的账号:如 "1054602781@qq.com"
     * @param loginAuthCode 登录qq邮箱时候需要的授权码:可以进入qq邮箱,账号设置那里"生成授权码"
     * @param sender 发件人
     * @param recipients 收件人:支持群发
     * @param emailSubject 邮件的主题
     * @param emailContent 邮件的内容
     * @param resource 附件的路径
     * @param emailContentType 邮件内容的类型,支持纯文本:"text/plain;charset=utf-8";,带有Html格式的内容:"text/html;charset=utf-8"
     * @return
     */
    public static int sendEmail(String mailServer,final String loginAccount,final String loginAuthCode,String sender,String[] recipients,
                                String emailSubject,String emailContent,String emailContentType,String resource){
        int res=0;

        try {
            //跟smtp服务器建立一个连接
            Properties p = new Properties();
            //设置邮件服务器主机名
            p.setProperty("mail.host",mailServer);
            //发送服务器需要身份验证,要采用指定用户名密码的方式去认证
            p.setProperty("mail.smtp.auth", "true");
            //发送邮件协议名称
            p.setProperty("mail.transport.protocol", "smtp");

            //开启SSL加密，否则会失败
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            p.put("mail.smtp.ssl.enable", "true");
            p.put("mail.smtp.ssl.socketFactory", sf);

            // 创建session
            Session session = Session.getDefaultInstance(p, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    //用户名可以用QQ账号也可以用邮箱的别名:第一个参数为邮箱账号,第二个为授权码
                    PasswordAuthentication pa = new PasswordAuthentication(loginAccount,loginAuthCode);
                    return pa;
                }
            });

            //设置打开调试状态
            session.setDebug(true);

            //可以发送几封邮件:可以在这里 for循环多次
            //声明一个Message对象(代表一封邮件),从session中创建
            MimeMessage msg = new MimeMessage(session);
            //邮件信息封装
            //1发件人
            msg.setFrom(new InternetAddress(sender));

            //2收件人:可以多个
            //一个的收件人
            //msg.setRecipient(RecipientType.TO, new InternetAddress("收件人邮箱-自己填"));

            InternetAddress[] receptientsEmail=new InternetAddress[recipients.length];
            for(int i=0;i<recipients.length;i++){
                receptientsEmail[i]=new InternetAddress(recipients[i]);
            }

            //多个收件人
            msg.setRecipients(RecipientType.TO,receptientsEmail);

            //3邮件内容:主题、内容
            msg.setSubject(emailSubject);
            //msg.setContent("Hello, 我是debug!!!", );//纯文本
            //msg.setContent(emailContent,emailContentType);//发html格式的文本

            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();
            // 消息
            messageBodyPart.setText(emailContent);
            // 创建多重消息
            Multipart multipart = new MimeMultipart();

            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);
            // 附件部分
            messageBodyPart = new MimeBodyPart();
            // 设置要发送附件的文件路径
            DataSource source = new FileDataSource(resource);
            messageBodyPart.setDataHandler(new DataHandler(source));

            // messageBodyPart.setFileName(filename);
            // 处理附件名称中文（附带文件路径）乱码问题
            messageBodyPart.setFileName(MimeUtility.encodeText(resource));
            multipart.addBodyPart(messageBodyPart);
            // 发送完整消息
            msg.setContent(multipart);

            //发送动作
            Transport.send(msg);
            System.out.println("邮件发送成功");
            res=1;

        } catch (Exception e) {
            System.out.println("邮件发送失败: "+e.getMessage());

            res=0;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {

        //邮件内容
        String mailServer="smtp.qq.com";
        final String loginAccount="你设置的发件邮箱";
        final String loginAuthCode="你生成的授权码";
        String sender="你设置的发件箱";
        String[] recipients={"420804356@qq.com","shukai.fun@foxmail.com"};//这里就是一系列的收件人的邮箱了
        String emailSubject= "你好";
        String code=smsCode();
        //String emailContent= "你好,欢迎来我的blog: <a href='https://shukai.fun/'>我的blog:划水的鱼</a>,祝您生活愉快!";//发HTML格式的文本
        String emailContent= "你好,欢迎来我的博客【划水的鱼】,你的验证码为："+code+"，切勿将验证码泄漏于他人。";//纯文本
        String emailContentType="text/html;charset=utf-8";
        String resource="D:\\001.txt";//附件路径

        int res=sendEmail(mailServer, loginAccount, loginAuthCode, sender, recipients, emailSubject, emailContent,emailContentType,resource);

        System.out.println("\n发送结果:"+res);
    }
    /**
     * @Tittle smsCode
     * @decription 创建验证码
     * @author shukai
     * @date 2019-10-22
     */
    public static String smsCode(){
        //int类型转字符串类型(后面直接加一个字符串)
        //随机产生一个数字范围为0-1000000
        String ran=new Random().nextInt(1000000)+"";
        //作一个判断条件使产生的数字的位数为6位

        if(ran.length()!=6){
            //递归（如果长度不是6位就再调一下自己做判断）
            return smsCode();
        }else{
            return ran;
        }
    }

}
