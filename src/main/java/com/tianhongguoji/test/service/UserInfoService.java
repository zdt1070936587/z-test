package com.tianhongguoji.test.service;

import com.tianhongguoji.test.config.GetDefaultImage;
import com.tianhongguoji.test.config.GetRandomStr;
import com.tianhongguoji.test.config.exception.CustomException;
import com.tianhongguoji.test.constant.TestConstant;
import com.tianhongguoji.test.domain.UserInfo;
import com.tianhongguoji.test.domain.view.TestVO;
import com.tianhongguoji.test.domain.view.UserInfoVO;
import com.tianhongguoji.test.rabbitmq.TestProducer;
import com.tianhongguoji.test.repo.UserInfoRepository;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 名称： UserInfoService
 * 作者： zdt
 * 日期： 2020-02-28 19:30
 * 描述： 用户业务
 **/
@Service
public class UserInfoService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private TestProducer testProducer;
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private RedisTemplate redisTemplate;

    public void randomAddUserInfo() {
        UserInfo userInfo = new UserInfo();
        String nickName = GetRandomStr.generateString(10);
        userInfo.setNickName(nickName);
        userInfo.setImage(GetDefaultImage.getDefaultHeadPortraitImageAddress(nickName));
        userInfo.setPersonalProfile(TestConstant.DEFAULT_PERSONAL_PROFILE);
        userInfo.setSex(new Random().nextInt(2));
        userInfoRepository.save(userInfo);
        TestVO testVO = new TestVO(userInfo);
        logger.info("UserInfoService randomAddUserInfo 添加完用户发送消息！");
        testProducer.testOutPut(testVO);
        logger.info("UserInfoService randomAddUserInfo 添加完用户发送延时消息！");
        testProducer.delayOutPut(testVO);
        logger.info("UserInfoService randomAddUserInfo 添加完用户后放缓存！");
        RAtomicLong userId_redis = redissonClient.getAtomicLong("REDISSON_USER_KEY:"+testVO.getId());
        userId_redis.set(testVO.getId());
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set("REDIS_USER_KEY:"+testVO.getId(), testVO.getName());
        redisTemplate.executePipelined(new SessionCallback<Object>() {
            @Override
            public <K, V> Object execute(RedisOperations<K, V> redisOperations) throws DataAccessException {
                for (int i = 0; i < 5; i++) {
                    redisTemplate.opsForValue().set("REDIS_USER_KEY_Pipelined", testVO.getId() + i);
                }
                return null;
            }
        });
        redisTemplate.expire("REDIS_USER_KEY:"+testVO.getId(), 100, TimeUnit.SECONDS);
        logger.info("UserInfoService randomAddUserInfo 添加完用户后放缓存结束！");
    }

    public UserInfoVO findUserInfoById(Long id) {
        UserInfo userInfo = userInfoRepository.findById(id).orElse(null);
        if (userInfo == null) {
            throw new CustomException(401,"用户信息不存在！");
        }
        return new UserInfoVO(userInfo);
    }

    public void testMQ(TestVO testVO) {
        System.out.println("testMQ UserInfoService : "+testVO);
        RAtomicLong userId_redis = redissonClient.getAtomicLong("testMQ_REDISSON_USER_KEY:"+testVO.getId());
        userId_redis.set(testVO.getId());
        System.out.println("testMQ : "+userId_redis);
    }

    public void testDelayMQ(TestVO testVO) {
        System.out.println("testDelayMQ UserInfoService : "+testVO);
        RAtomicLong userId_redis = redissonClient.getAtomicLong("testDelayMQ_REDISSON_USER_KEY:"+testVO.getId());
        userId_redis.set(testVO.getId());
        System.out.println("testDelayMQ : "+userId_redis);
    }

}
