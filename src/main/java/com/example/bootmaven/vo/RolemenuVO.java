package com.example.bootmaven.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 角色-菜单对应表
 * </p>
 *
 * @author robin
 * @since 2022-07-01
 */
@Data
@ApiModel(value = "Rolemenu对象", description = "角色-菜单对应表")
public class RolemenuVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("roleid")
    private String roleid;

    @TableField("menuid")
    private String menuid;

    @TableField("createat")
    private String createat;

    @TableField("createby")
    private String createby;

    @TableField("updateat")
    private String updateat;

    @TableField("updateby")
    private String updateby;


}
