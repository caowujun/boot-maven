package com.example.bootmaven.vo;

    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import io.swagger.annotations.ApiModel;
    import lombok.Data;

/**
* <p>
    * 运动记录
    * </p>
*
* @author robin
* @since 2022-06-29
*/
    @Data
    @ApiModel(value = "Fire对象", description = "运动记录")
    public class FireVO implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("id")
    private String id;

        @TableField("recorddate")
    private LocalDate recorddate;

        @TableField("weight")
    private Double weight;

        @TableField("sex")
    private Integer sex;

        @TableField("createat")
    private LocalDateTime createat;

        @TableField("createby")
    private String createby;

        @TableField("updateat")
    private LocalDateTime updateat;

        @TableField("updateby")
    private String updateby;


}
