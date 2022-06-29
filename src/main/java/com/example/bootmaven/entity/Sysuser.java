package com.example.bootmaven.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author robin
 * @since 2022-06-29
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

    @TableField("createat")
    private LocalDateTime createat;

    @TableField("updateat")
    private LocalDateTime updateat;


}
