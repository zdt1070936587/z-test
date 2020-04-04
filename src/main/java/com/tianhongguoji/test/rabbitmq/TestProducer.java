package com.tianhongguoji.test.rabbitmq;

import com.tianhongguoji.test.domain.view.TestVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

/**
 * 名称： UserInfoService
 * 作者： zdt
 * 日期： 2020-02-28 19:30
 * 描述： Producer
 */
@EnableBinding({ TestChannels.class })
public class TestProducer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestChannels channel;

    public void testOutPut(TestVO testVO) {
        logger.info("testOutPut message:" + testVO);
        channel.testOutPut().send(MessageBuilder.withPayload(testVO).setHeader("routing-key",
                "test.routingKey").build());
    }

    public void delayOutPut(TestVO testVO) {
        logger.info("delayOutPut message:" + testVO);
        channel.delayOutPut().send(MessageBuilder.withPayload(testVO).setHeader("x-delay",
                30000).build());
    }


}
