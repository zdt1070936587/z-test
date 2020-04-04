package com.tianhongguoji.test.domain.view;

import com.tianhongguoji.test.domain.UserInfo;
import lombok.Data;

import java.util.Date;

/**
 * 名称： TestVO
 * 作者： zdt
 * 日期： 2020-03-28 11:03
 * 描述： 测试
 **/
@Data
public class TestVO {
    private Long id;
    private String name;
    //发送时间
    private Date sendOutTime;
    //接收时间
    private Date receiveTime;
    public TestVO(){}
    public TestVO(UserInfo userInfo){
        id = userInfo.getId();
        name = userInfo.getNickName();
        sendOutTime = new Date();
    }
}
