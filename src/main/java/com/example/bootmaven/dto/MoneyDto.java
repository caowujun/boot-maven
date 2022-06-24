package com.example.bootmaven.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author robin
 * @since 2022-06-24
 */
@Getter
@Setter
@TableName("money")
@ApiModel(value = "Money对象", description = "")
public class MoneyDto implements Serializable {

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
