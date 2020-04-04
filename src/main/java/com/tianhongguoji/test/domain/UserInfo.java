package com.tianhongguoji.test.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * 名称： UserInfo
 * 作者： zdt
 * 日期： 2020-02-28 19:14
 * 描述： 用户表
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_user_info")
public class UserInfo extends BaseModel {

    @ApiModelProperty("昵称")
    @Column(columnDefinition = "char(50) not null default '' comment '昵称'")
    private String nickName;

    @ApiModelProperty("性别 0 未知 1 男 2女")
    @Column(columnDefinition = "tinyint(1) default 0 comment '性别 0 未知 1 男 2女'")
    private Integer sex;

    @ApiModelProperty("头像")
    @Column(columnDefinition = "varchar(1000) default '' comment '头像'")
    private String image;

    @ApiModelProperty("简介")
    @Column(columnDefinition = "char(100) default '' comment '简介'")
    private String personalProfile;

}
