package com.tianhongguoji.test.config;

import java.util.Random;

/**
 * 名称： getRandomStr
 * 作者： zdt
 * 日期： 2020-02-28 20:15
 * 描述： 获取一个随机定长的字符串
 **/
public class GetRandomStr {

    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String numberChar = "0123456789";

    //参数为返回随机数的长度
    public static String generateString(int length)
    {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++)
        {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }


}
