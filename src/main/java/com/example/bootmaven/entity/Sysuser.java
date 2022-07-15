package com.example.bootmaven.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
    @Size(min = 3, max = 20, message = "用户名长度只能在6-20之间")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @TableField("userpsd")
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度只能在6-20之间")
    private String userpsd;

    @TableField("cnname")
    @NotBlank(message = "姓名不能为空")
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
