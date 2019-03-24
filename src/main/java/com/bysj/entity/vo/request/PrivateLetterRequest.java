package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * PrivateLetterRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class PrivateLetterRequest  {

    /**
     *  接收者id
     */
    @ApiModelProperty("接收者id(用于发送方)")
    private Integer userSendRev;
    /**
     *  内容
     */
    @ApiModelProperty("内容")
    private String content;



    public Integer getUserSendRev() {
    return userSendRev;
    }

    public void setUserSendRev(Integer userSendRev) {
        this.userSendRev = userSendRev;
        }


    public String getContent() {
    return content;
    }

    public void setContent(String content) {
        this.content = content;
        }





}