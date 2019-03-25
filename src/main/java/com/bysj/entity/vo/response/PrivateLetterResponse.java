package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * PrivateLetterResponse 响应对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class PrivateLetterResponse extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     * 私信类型:1 用户私信,2 系统私信
     */
    @ApiModelProperty("私信类型:1 用户私信,2 系统私信")
    private Integer letterType;
    /**
     * 发送者id（用于接收者）
     */
    @ApiModelProperty("发送者id（用于接收者）")
    private Integer userRevSend;

    private String userRevSendName;




    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }




    public Integer getLetterType() {
        return letterType;
    }

    public void setLetterType(Integer letterType) {
        this.letterType = letterType;
    }


    public Integer getUserRevSend() {
        return userRevSend;
    }

    public void setUserRevSend(Integer userRevSend) {
        this.userRevSend = userRevSend;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"content\":\"")
                .append(content).append('\"');
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"letterType\":")
                .append(letterType);
        sb.append(",\"userRevSend\":")
                .append(userRevSend);
        sb.append(",\"userRevSendName\":\"")
                .append(userRevSendName).append('\"');
        sb.append('}');
        return sb.toString();
    }
}