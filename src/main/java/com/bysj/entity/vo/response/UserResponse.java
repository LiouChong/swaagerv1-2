package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModel;
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

public class UserResponse extends BaseEntity {
    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String psw;
    /**
     * 积分
     */
    @ApiModelProperty("积分")
    private Integer money;
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String picture;
    /**
     * 个性签名
     */
    @ApiModelProperty("个性签名")
    private String signaTure;
    /**
     * 性别:1 男,2 女
     */
    @ApiModelProperty("性别:1 男,0 女")
    private Integer sex;

    private String sexStr;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    @ApiModelProperty("创建时间字符串")
    private String gmtCreateStr;

    /**
     * 粉丝数
     */
    @ApiModelProperty("粉丝数")
    private Integer fanCount;

    /**
     * 管理板块名称
     */
    @ApiModelProperty("管理的板块名称")
    private List<String> plateName;

    /**
     * 状态，1 有效0 无效
     */
    @ApiModelProperty("状态:1 有效,0 无效")
    private Integer state;

    private String stateStr;

    /**
     * 修改时间
     */
    private String gmtModify;

    /**
     * 修改人名称
     */
    private String modifyUserName;

    /**
     * 封禁理由
     */
    private String banReason;

    public String getBanReason() {
        return banReason;
    }

    public void setBanReason(String banReason) {
        this.banReason = banReason;
    }

    public String getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSignaTure() {
        return signaTure;
    }

    public void setSignaTure(String signaTure) {
        this.signaTure = signaTure;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getFanCount() {
        return fanCount;
    }

    public void setFanCount(Integer fanCount) {
        this.fanCount = fanCount;
    }

    public List<String> getPlateName() {
        return plateName;
    }

    public void setPlateName(List<String> plateName) {
        this.plateName = plateName;
    }

    public String getGmtCreateStr() {
        return gmtCreateStr;
    }

    public void setGmtCreateStr(String gmtCreateStr) {
        this.gmtCreateStr = gmtCreateStr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"psw\":\"")
                .append(psw).append('\"');
        sb.append(",\"money\":")
                .append(money);
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"picture\":\"")
                .append(picture).append('\"');
        sb.append(",\"signaTure\":\"")
                .append(signaTure).append('\"');
        sb.append(",\"sex\":")
                .append(sex);
        sb.append(",\"sexStr\":\"")
                .append(sexStr).append('\"');
        sb.append(",\"age\":")
                .append(age);
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"gmtCreateStr\":\"")
                .append(gmtCreateStr).append('\"');
        sb.append(",\"fanCount\":")
                .append(fanCount);
        sb.append(",\"plateName\":")
                .append(plateName);
        sb.append(",\"state\":")
                .append(state);
        sb.append(",\"stateStr\":\"")
                .append(stateStr).append('\"');
        sb.append(",\"gmtModify\":\"")
                .append(gmtModify).append('\"');
        sb.append(",\"modifyUserName\":\"")
                .append(modifyUserName).append('\"');
        sb.append(",\"banReason\":\"")
                .append(banReason).append('\"');
        sb.append('}');
        return sb.toString();
    }
}