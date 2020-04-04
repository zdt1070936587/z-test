package com.tianhongguoji.test.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * 名称： UserInfoService
 * 作者： zdt
 * 日期： 2020-02-28 19:30
 * 描述： Channels
 **/
@Component
public interface TestChannels {
    String TEST_OUT_PUT = "test_output";
    String TEST_IN_PUT = "test_input";

    String DELAY_OUT_PUT = "delay_output";
    String DELAY_IN_PUT = "delay_input";

    @Output(TEST_OUT_PUT)
    MessageChannel testOutPut();

    @Input(TEST_IN_PUT)
    MessageChannel testInPut();

    @Output(DELAY_OUT_PUT)
    MessageChannel delayOutPut();

    @Input(DELAY_IN_PUT)
    SubscribableChannel delayInPut();

}
