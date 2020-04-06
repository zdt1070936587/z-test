package com.tianhongguoji.test.config.email;

import lombok.Data;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 名称： MailSMTPAuthenticator
 * 作者：
 * 日期： 2020-04-05 19:19
 * 描述：
 **/
@Data
public class MailSMTPAuthenticator extends Authenticator {
    private String sName;
    private String sPassword;
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(sName, sPassword);
    }
}
