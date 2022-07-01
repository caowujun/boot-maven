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
    * 执行日志
    * </p>
*
* @author robin
* @since 2022-07-01
*/
    @Data
    @ApiModel(value = "Runninglog对象", description = "执行日志")
    public class RunninglogVO implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("id")
        private String id;

        @TableField("logcontent")
        private String logcontent;

        @TableField("actiontype")
        private Integer actiontype;

        @TableField("createat")
        private String createat;

        @TableField("createby")
        private String createby;

        @TableField("updateat")
        private String updateat;

        @TableField("updateby")
        private String updateby;


}
