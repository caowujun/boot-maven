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
 * 系统用户
 * </p>
 *
 * @author robin
 * @since 2022-07-04
 */
@Data
@TableName("sysuser")
@ApiModel(value = "Sysuser对象", description = "系统用户")
public class Sysuser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("username")
    private String username;

    @TableField("userpsd")
    private String userpsd;

    @TableField("cnname")
    private String cnname;

    @TableField("phonenum")
    private String phonenum;

    @TableField("status")
    private Integer status;

    @TableField(value = "createat", fill = FieldFill.INSERT)
    private LocalDateTime createat;

    @TableField("createby")
    private String createby;

    @TableField(value = "updateat", fill = FieldFill.UPDATE)
    private LocalDateTime updateat;

    @TableField("updateby")
    private String updateby;


}
