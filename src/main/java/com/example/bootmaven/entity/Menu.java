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
    * 菜单
    * </p>
*
* @author robin
* @since 2022-06-29
*/
    @Data
    @TableName("menu")
    @ApiModel(value = "Menu对象", description = "菜单")
    public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("id")
    private String id;

        @TableField("parentid")
    private String parentid;

        @TableField("title")
    private String title;

        @TableField("actionurl")
    private String actionurl;

        @TableField("status")
    private Integer status;

        @TableField("sortindex")
    private Integer sortindex;

        @TableField("icon")
    private String icon;

        @TableField("createat")
    private LocalDateTime createat;

        @TableField("createby")
    private String createby;

        @TableField("updateat")
    private LocalDateTime updateat;

        @TableField("updateby")
    private String updateby;


}
