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
    * 系统公告
    * </p>
*
* @author robin
* @since 2022-07-01
*/
    @Data
    @ApiModel(value = "Noticeboard对象", description = "系统公告")
    public class NoticeboardVO implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("id")
        private String id;

        @TableField("noticetitle")
        private String noticetitle;

        @TableField("noticecontent")
        private String noticecontent;

        @TableField("noticetype")
        private Integer noticetype;

        @TableField("createat")
        private String createat;

        @TableField("createby")
        private String createby;

        @TableField("updateat")
        private String updateat;

        @TableField("updateby")
        private String updateby;


}
