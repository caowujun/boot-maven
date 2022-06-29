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
    * 角色-菜单对应表
    * </p>
*
* @author robin
* @since 2022-06-29
*/
    @Data
    @TableName("rolemenu")
    @ApiModel(value = "Rolemenu对象", description = "角色-菜单对应表")
    public class Rolemenu implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("id")
    private String id;

        @TableField("roleid")
    private String roleid;

        @TableField("menuid")
    private String menuid;

        @TableField("createat")
    private LocalDateTime createat;

        @TableField("createby")
    private String createby;

        @TableField("updateat")
    private LocalDateTime updateat;

        @TableField("updateby")
    private String updateby;


}
