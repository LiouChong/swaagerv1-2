package com.bysj.entity;



import com.bysj.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 私信表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class PrivateLetter extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer fromUserId;
    @ApiModelProperty("")
    private String content;
    @ApiModelProperty("")
    private Integer toUserId;
    @ApiModelProperty("")
    private Boolean ifRead;
    @ApiModelProperty("")
    private Boolean ifDelete;


    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }


    public Boolean getIfRead() {
        return ifRead;
    }

    public void setIfRead(Boolean ifRead) {
        this.ifRead = ifRead;
    }


    public Boolean getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(Boolean ifDelete) {
        this.ifDelete = ifDelete;
    }


    @Override
    public String toString() {
        return "PrivateLetter{" +
                ", fromUserId=" + fromUserId +
                ", content=" + content +
                ", toUserId=" + toUserId +
                ", ifRead=" + ifRead +
                ", ifDelete=" + ifDelete +
                "}";
    }
}