package com.tianhongguoji.test.config.email;

import lombok.Data;

/**
 * 名称： MailConfig
 * 作者：
 * 日期： 2020-04-05 19:12
 * 描述：
 **/
@Data
public class MailConfig {
    private String SMTP_host;
    private Integer SMTP_port;
    private Boolean SMTP_auth;
    private String STMP_user;
    private String STMP_pass;
    private String SMTP_from;
    private String SMTP_from_nick;
}
