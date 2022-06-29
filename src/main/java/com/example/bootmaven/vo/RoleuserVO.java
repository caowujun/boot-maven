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
 * 角色-用户对应表
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Data
@ApiModel(value = "Roleuser对象", description = "角色-用户对应表")
public class RoleuserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("roleid")
    private String roleid;

    @TableField("userid")
    private String userid;

    @TableField("createat")
    private LocalDateTime createat;

    @TableField("createby")
    private String createby;

    @TableField("updateat")
    private LocalDateTime updateat;

    @TableField("updateby")
    private String updateby;


}
