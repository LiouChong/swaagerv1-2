package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户详细信息响应对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class UserLevellResponse extends BaseEntity {
    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;


    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 级别
     */
    @ApiModelProperty("级别:1 普通用户,2 版主,3 admin")
    private Integer level;

    private String levelStr;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date userGmtCreate;
    private String userGmtCreateStr;

    /**
     * 管理板块名称
     */
    @ApiModelProperty("管理的板块名称")
    private String plateName;

    /**
     * 开始当版主时间
     */
    private Date platerGmtCreate;

    private String platerGmtCreateStr;

    /**
     * 管理的月数
     */
    private Integer manageTime;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelStr() {
        return levelStr;
    }

    public void setLevelStr(String levelStr) {
        this.levelStr = levelStr;
    }

    public String getUserGmtCreateStr() {
        return userGmtCreateStr;
    }

    public void setUserGmtCreateStr(String userGmtCreateStr) {
        this.userGmtCreateStr = userGmtCreateStr;
    }

    public Integer getManageTime() {
        return manageTime;
    }

    public void setManageTime(Integer manageTime) {
        this.manageTime = manageTime;
    }

    public Date getUserGmtCreate() {
        return userGmtCreate;
    }

    public void setUserGmtCreate(Date userGmtCreate) {
        this.userGmtCreate = userGmtCreate;
    }

    public Date getPlaterGmtCreate() {
        return platerGmtCreate;
    }

    public void setPlaterGmtCreate(Date platerGmtCreate) {
        this.platerGmtCreate = platerGmtCreate;
    }

    public String getPlaterGmtCreateStr() {
        return platerGmtCreateStr;
    }

    public void setPlaterGmtCreateStr(String platerGmtCreateStr) {
        this.platerGmtCreateStr = platerGmtCreateStr;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"level\":\"")
                .append(level).append('\"');
        sb.append(",\"levelStr\":\"")
                .append(levelStr).append('\"');
        sb.append(",\"userGmtCreate\":\"")
                .append(userGmtCreate).append('\"');
        sb.append(",\"plateName\":\"")
                .append(plateName).append('\"');
        sb.append(",\"platerGmtCreate\":\"")
                .append(platerGmtCreate).append('\"');
        sb.append(",\"platerGmtCreateStr\":\"")
                .append(platerGmtCreateStr).append('\"');
        sb.append(",\"manageTime\":")
                .append(manageTime);
        sb.append('}');
        return sb.toString();
    }
}