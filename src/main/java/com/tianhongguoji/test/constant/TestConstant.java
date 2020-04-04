package com.tianhongguoji.test.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 名称： testConstant
 * 作者： zdt
 * 日期： 2020-02-28 20:52
 * 描述： 常量池
 **/
public class TestConstant {

    public static final Map MAP = new HashMap();

    static {
        MAP.put("s",120);
        MAP.put("d","identicon");
    }

    public static final String DEFAULT_HEAD_PORTRAIT_IMAGE_ADDRESS = "http://cn.gravatar.com/avatar/";

    public static final String DEFAULT_PERSONAL_PROFILE = "***********";

}
