package com.tianhongguoji.test.rabbitmq;

import com.tianhongguoji.test.domain.view.TestVO;
import com.tianhongguoji.test.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


/**
 * 名称： UserInfoService
 * 作者： zdt
 * 日期： 2020-02-28 19:30
 * 描述： Consumer
 */
@EnableBinding({TestChannels.class})
public class TestConsumer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoService userInfoService;

    @StreamListener(value = TestChannels.TEST_IN_PUT)
    public void testInPut(@Payload TestVO testVO){
        logger.info("testInPut begin testVO-{} 接受消息开始", testVO);
        try{
            userInfoService.testMQ(testVO);
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("testInPut end OK 接受消息结束");
    }

    @StreamListener(value = TestChannels.DELAY_IN_PUT)
    public void delayInPut(@Payload TestVO testVO){
        logger.info("delayInPut begin testVO-{} 接受延迟消息开始", testVO);
        try{
            userInfoService.testDelayMQ(testVO);
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("delayInPut end OK 接受延迟消息结束");
    }

}