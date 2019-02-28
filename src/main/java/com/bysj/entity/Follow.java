package com.bysj.entity;


import java.util.Date;
import com.antiy.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 关注人表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class Follow extends BaseEntity {


private static final long serialVersionUID = 1L;

        /**
    *  粉丝id
    */
        @ApiModelProperty("粉丝id")
    private Integer fanId;
        /**
    *  被关注者id
    */
        @ApiModelProperty("被关注者id")
    private Integer starId;
        /**
    *  创建时间
    */
        @ApiModelProperty("创建时间")
    private Date gmtCreate;


    public Integer getFanId() {
        return fanId;
    }

    public void setFanId(Integer fanId) {
        this.fanId = fanId;
    }


    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }


    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }


        @Override
    public String toString() {
            return "Follow{" +
                                                            "fanId=" + fanId +
                                                                                        ", starId=" + starId +
                                                                                        ", gmtCreate=" + gmtCreate +
                                                "}";
    }
    }