package com.tianhongguoji.test.domain.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tianhongguoji.test.domain.UserInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * 名称： UserInfoVO
 * 作者： zdt
 * 日期： 2020-02-28 19:37
 * 描述： 用户VO
 **/
@Data
public class UserInfoVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("性别 0 未知 1 男 2女")
    private Integer sex;

    @ApiModelProperty("头像")
    private String image;

    @ApiModelProperty("简介")
    private String personalProfile;

    @Column(name = "创建时间")
    private Date createTime;

    @Column(name = "修改时间")
    private Date updateTime;

    public UserInfoVO(UserInfo userInfo) {
        id = userInfo.getId();
        nickName = userInfo.getNickName();
        sex = userInfo.getSex();
        image = userInfo.getImage();
        personalProfile = userInfo.getPersonalProfile();
        createTime = userInfo.getCreateTime();
        updateTime = userInfo.getUpdateTime();
    }
}
