package com.example.bootmaven.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 枚举配置
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Data
@ApiModel(value = "Enumtypes对象", description = "枚举配置")
public class EnumtypesVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("parentid")
    private String parentid;

    @TableField("enumname")
    private String enumname;

    @TableField("enumvalue")
    private String enumvalue;

    @TableField("enumtype")
    private String enumtype;

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
