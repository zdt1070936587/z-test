package com.tianhongguoji.test.domain;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZHAO
 *
 * @date 2020年2月28日
 *
 * @description 实体类基本模型
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "com.tianhongguoji.test.config.idGenerator.IDGenerator")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@ApiModelProperty(value = "主键", name = "id")
	private Long id;
	@ApiModelProperty(value = "状态(0正常 -1删除,默认正常:0)", name = "status")
	private Short status=0;

	@Version
	private int version;

	@CreatedDate
	@Column(name = "create_time")
	@ApiModelProperty(value = "创建日期", name = "createTime")
	private Date createTime;

	@LastModifiedDate
	@Column(name = "update_time")
	@ApiModelProperty(value = "修改日期", name = "updateTime")
	private Date updateTime;
}
