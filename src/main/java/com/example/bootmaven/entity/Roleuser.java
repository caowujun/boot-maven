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
    * 角色-用户对应表
    * </p>
*
* @author robin
* @since 2022-07-04
*/
    @Data
    @TableName("roleuser")
    @ApiModel(value = "Roleuser对象", description = "角色-用户对应表")
    public class Roleuser implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("id")
    private String id;

        @TableField("roleid")
    private String roleid;

        @TableField("userid")
    private String userid;

            @TableField(value = "createat", fill = FieldFill.INSERT)
    private LocalDateTime createat;

        @TableField("createby")
    private String createby;

            @TableField(value = "updateat", fill = FieldFill.UPDATE)
    private LocalDateTime updateat;

        @TableField("updateby")
    private String updateby;


}
