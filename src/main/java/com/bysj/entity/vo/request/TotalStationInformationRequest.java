package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * TotalStationInformationRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class TotalStationInformationRequest  {

    /**
     *  通知内容
     */
    @ApiModelProperty("通知内容")
    private String content;
    /**
     *  通知时间
     */
    @ApiModelProperty("通知时间")
    private Date time;
    /**
     *  发出消息者名称
     */
    @ApiModelProperty("发出消息者名称")
    private String userName;
    /**
     *  创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     *  修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModify;
    /**
     *  创建用户id
     */
    @ApiModelProperty("创建用户id")
    private Integer userCreate;
    /**
     *  修改用户id
     */
    @ApiModelProperty("修改用户id")
    private Integer userModify;
    /**
     *  状态，1 有效 2 无效
     */
    @ApiModelProperty("状态，1 有效 2 无效")
    private Integer state;



    public String getContent() {
    return content;
    }

    public void setContent(String content) {
        this.content = content;
        }


    public Date getTime() {
    return time;
    }

    public void setTime(Date time) {
        this.time = time;
        }


    public String getUserName() {
    return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        }


    public Date getGmtCreate() {
    return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        }


    public Date getGmtModify() {
    return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
        }


    public Integer getUserCreate() {
    return userCreate;
    }

    public void setUserCreate(Integer userCreate) {
        this.userCreate = userCreate;
        }


    public Integer getUserModify() {
    return userModify;
    }

    public void setUserModify(Integer userModify) {
        this.userModify = userModify;
        }


    public Integer getState() {
    return state;
    }

    public void setState(Integer state) {
        this.state = state;
        }




}