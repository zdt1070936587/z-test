package com.tianhongguoji.test.config.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 名称： MailConfiguration
 * 作者：
 * 日期： 2020-04-05 19:14
 * 描述：
 **/
@Configuration
public class MailConfiguration {
    @Value("${mail.config.SMTP_host}")
    private String SMTP_host;
    @Value("${mail.config.SMTP_port}")
    private String SMTP_port;
    @Value("${mail.config.SMTP_auth}")
    private String SMTP_auth;
    @Value("${mail.config.STMP_user}")
    private String STMP_user;
    @Value("${mail.config.STMP_pass}")
    private String STMP_pass;
    @Value("${mail.config.SMTP_from}")
    private String SMTP_from;
    @Value("${mail.config.SMTP_from_nick}")
    private String SMTP_from_nick;
    @Bean
    public MailConfig getmailConfig(){
        MailConfig mc = new MailConfig();
        mc.setSMTP_host(SMTP_host);
        mc.setSMTP_port(Integer.parseInt(SMTP_port));
        mc.setSMTP_auth(Boolean.parseBoolean(SMTP_auth));
        mc.setSTMP_user(STMP_user);
        mc.setSTMP_pass(STMP_pass);
        mc.setSMTP_from(SMTP_from);
        mc.setSMTP_from_nick(SMTP_from_nick);
        return mc;
    }
}
