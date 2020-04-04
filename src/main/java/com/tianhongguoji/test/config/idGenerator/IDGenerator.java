package com.tianhongguoji.test.config.idGenerator;


import com.tianhongguoji.test.util.SpringUtils;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * @Name IDGenerator
 * @Author zhangtao
 * @Date 2019-12-04 11:12 上午
 * @Description 自定义ID生成器
 * @Version
 **/
public class IDGenerator extends IdentityGenerator {
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws MappingException {
		SnowBeanConfig bean = SpringUtils.getBean(SnowBeanConfig.class);
		Object id =  bean.getIdWorker().nextId();
		if (id != null) {
			return (Serializable) id;
		}
		return super.generate(session, object);
	}
}