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
    * 消费
    * </p>
*
* @author robin
* @since 2022-06-29
*/
    @Data
    @TableName("money")
    @ApiModel(value = "Money对象", description = "消费")
    public class Money implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("id")
    private String id;

        @TableField("spendnum")
    private Double spendnum;

        @TableField("moneytype")
    private Integer moneytype;

        @TableField("note")
    private String note;

        @TableField("recorddate")
    private String recorddate;

        @TableField("consumptiontype")
    private String consumptiontype;

        @TableField("createat")
    private LocalDateTime createat;

        @TableField("createby")
    private String createby;

        @TableField("updateat")
    private LocalDateTime updateat;

        @TableField("updateby")
    private String updateby;


}
