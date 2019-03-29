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

public class PrivateLetterForMyResponse extends BaseEntity {

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
    private String gmtCreateStr;

    /**
     *接收用户id
     */
    private Integer userSendRev;
    /**
     * 接收人姓名
     */
    private String userSendRevName;

    /**
     * 发送者id
     */
    private Integer userRevSend;

    /**
     * 发送者姓名
     */
    private String userRevSendName;

    private Integer ifRead;

    public Integer getIfRead() {
        return ifRead;
    }

    public void setIfRead(Integer ifRead) {
        this.ifRead = ifRead;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"content\":\"")
                .append(content).append('\"');
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"gmtCreateStr\":\"")
                .append(gmtCreateStr).append('\"');
        sb.append(",\"userSendRev\":")
                .append(userSendRev);
        sb.append(",\"userSendRevName\":\"")
                .append(userSendRevName).append('\"');
        sb.append(",\"userRevSend\":")
                .append(userRevSend);
        sb.append(",\"userRevSendName\":\"")
                .append(userRevSendName).append('\"');
        sb.append(",\"ifRead\":")
                .append(ifRead);
        sb.append('}');
        return sb.toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getUserSendRevName() {
        return userSendRevName;
    }

    public void setUserSendRevName(String userSendRevName) {
        this.userSendRevName = userSendRevName;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtCreateStr() {
        return gmtCreateStr;
    }

    public void setGmtCreateStr(String gmtCreateStr) {
        this.gmtCreateStr = gmtCreateStr;
    }

    public Integer getUserSendRev() {
        return userSendRev;
    }

    public void setUserSendRev(Integer userSendRev) {
        this.userSendRev = userSendRev;
    }

    public Integer getUserRevSend() {
        return userRevSend;
    }

    public void setUserRevSend(Integer userRevSend) {
        this.userRevSend = userRevSend;
    }

    public String getUserRevSendName() {
        return userRevSendName;
    }

    public void setUserRevSendName(String userRevSendName) {
        this.userRevSendName = userRevSendName;
    }

}