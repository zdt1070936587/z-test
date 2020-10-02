package com.tianhongguoji.test.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 名称： TestJob
 * 作者：
 * 日期： 2020-04-06 21:41
 * 描述： 测试定时任务
 **/
@Component
public class TestJob {

    private static int count = 0;

    /**
     * @Author Smith
     * @Description 设置没6秒执行一次
     * @Date 14:23 2019/1/24
     * @Param
     * @return void
     **/
    //@Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task running " + (count++) + "date:" + new Date());
    }

}
