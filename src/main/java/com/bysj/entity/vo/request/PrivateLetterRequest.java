package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * PrivateLetterRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class PrivateLetterRequest   {

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


}