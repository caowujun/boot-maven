package com.example.bootmaven.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * 角色
 * </p>
 *
 * @author robin
 * @since 2022-07-04
 */
@Data
@TableName("role")
@ApiModel(value = "Role对象", description = "角色")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("parentid")
    private String parentid;

    @TableField("title")
    private String title;

    @TableField("description")
    private String description;

    @TableField("status")
    private Integer status;

    @TableField("sortindex")
    private Integer sortindex;

    @TableField(value = "createat", fill = FieldFill.INSERT)
    private LocalDateTime createat;

    @TableField("createby")
    private String createby;

    @TableField(value = "updateat", fill = FieldFill.UPDATE)
    private LocalDateTime updateat;

    @TableField("updateby")
    private String updateby;


}
