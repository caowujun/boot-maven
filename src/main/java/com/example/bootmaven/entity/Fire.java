package com.example.bootmaven.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 运动记录
 * </p>
 *
 * @author robin
 * @since 2022-07-04
 */
@Data
@TableName("fire")
@ApiModel(value = "Fire对象", description = "运动记录")
public class Fire implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("recorddate")
    private LocalDate recorddate;

    @TableField("weight")
    private Double weight;

    @TableField("sex")
    private Integer sex;

    @TableField(value = "createat", fill = FieldFill.INSERT)
    private LocalDateTime createat;

    @TableField("createby")
    private String createby;

    @TableField(value = "updateat", fill = FieldFill.UPDATE)
    private LocalDateTime updateat;

    @TableField("updateby")
    private String updateby;


}
