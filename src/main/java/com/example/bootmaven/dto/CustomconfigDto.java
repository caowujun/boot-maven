package com.example.bootmaven.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 自定义配置
 * </p>
 *
 * @author robin
 * @since 2022-06-27
 */
@Getter
@Setter
@TableName("customconfig")
@ApiModel(value = "Customconfig对象", description = "自定义配置")
public class CustomconfigDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("configkey")
    private String configkey;

    @TableField("configvalue")
    private String configvalue;

    @TableField("description")
    private String description;

    @TableField("status")
    private Integer status;

    @TableField("createat")
    private LocalDateTime createat;

    @TableField("createby")
    private String createby;

    @TableField("updateat")
    private LocalDateTime updateat;

    @TableField("updateby")
    private String updateby;


}
