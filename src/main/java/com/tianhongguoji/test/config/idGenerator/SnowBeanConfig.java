package com.tianhongguoji.test.config.idGenerator;

import com.tianhongguoji.test.util.SnowFlakeId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowBeanConfig {
	@Bean
	public SnowFlakeId getIdWorker() {
		return new SnowFlakeId(0, 0);
	}

}
