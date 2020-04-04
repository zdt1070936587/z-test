package com.tianhongguoji.test.controller.user;

import com.tianhongguoji.test.domain.view.UserInfoVO;
import com.tianhongguoji.test.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 名称： UserController
 * 作者： zdt
 * 日期： 2020-02-28 19:49
 * 描述： 用户控制器
 **/
@Api(tags = "用户模块", description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "随机创建一个用户信息", notes="随机创建一个用户信息")
    @ResponseBody
    @PostMapping("randomAddUserInfo")
    public void randomAddUserInfo() {
        userInfoService.randomAddUserInfo();
    }

    @ApiOperation(value = "查询单个用户信息", notes="使用用户id查询用户信息")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "long")
    @ResponseBody
    @GetMapping
    public UserInfoVO findUserInfoById(@RequestParam(name = "id") Long id) {
        return userInfoService.findUserInfoById(id);
    }

}
