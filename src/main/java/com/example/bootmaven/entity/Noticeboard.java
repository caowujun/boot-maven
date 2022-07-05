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
 * 系统公告
 * </p>
 *
 * @author robin
 * @since 2022-07-04
 */
@Data
@TableName("noticeboard")
@ApiModel(value = "Noticeboard对象", description = "系统公告")
public class Noticeboard implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("noticetitle")
    private String noticetitle;

    @TableField("noticecontent")
    private String noticecontent;

    @TableField("noticetype")
    private Integer noticetype;

    @TableField(value = "createat", fill = FieldFill.INSERT)
    private LocalDateTime createat;

    @TableField("createby")
    private String createby;

    @TableField(value = "updateat", fill = FieldFill.UPDATE)
    private LocalDateTime updateat;

    @TableField("updateby")
    private String updateby;


}
