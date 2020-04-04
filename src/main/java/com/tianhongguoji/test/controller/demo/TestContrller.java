package com.tianhongguoji.test.controller.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "hello模块", description = "hello")
@RestController
@RequestMapping("test/")
public class TestContrller {

    @ApiOperation(value = "hello", notes="get Hello World !")
    @ApiImplicitParam(name = "name", value = "名称", paramType = "query", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("hello")
    public String getHomePageVideo(@RequestParam(name = "name") String name) {
        return "Hi ! " + name + " ：Hello World !";
    }

}
