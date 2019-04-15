package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * ChatRecordResponse 响应对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class ChatRecordResponse extends BaseEntity {

    /**
     * 聊天内容
     */
    @ApiModelProperty("聊天内容")
    private String content;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private String gmtCreate;
    /**
     * 创建者id
     */
    @ApiModelProperty("创建者id")
    private String nickname;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGmtCreate() {
        return gmtCreate.substring(0, gmtCreate.lastIndexOf("."));
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}