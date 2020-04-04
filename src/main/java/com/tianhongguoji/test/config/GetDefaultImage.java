package com.tianhongguoji.test.config;

import com.tianhongguoji.test.constant.TestConstant;
import com.tianhongguoji.test.util.HttpClientUtil;
import com.tianhongguoji.test.util.MD5Util;
import lombok.extern.log4j.Log4j2;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 名称： GetDefaultImage
 * 作者：
 * 日期： 2020-02-28 20:43
 * 描述： 默认头像
 **/
@Log4j2
public class GetDefaultImage {

    public static String getDefaultHeadPortraitImageAddress(String idNumber){
        String url = TestConstant.DEFAULT_HEAD_PORTRAIT_IMAGE_ADDRESS + MD5Util.md5(idNumber);
        try {
            url = HttpClientUtil.getUrl(url, TestConstant.MAP);
        } catch (UnsupportedEncodingException e) {
            log.error("获取默认头像地址失败 error-{}",e);
        }
        return url;
    }

}
