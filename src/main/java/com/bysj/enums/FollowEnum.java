package com.bysj.enums;

/**
 * 描述：
 **/
public enum FollowEnum {
    QUERY_FAN(1,"查询粉丝"),
    QUERY_FOLLOW(2,"查询关注的人");


    private String msg;
    private Integer code;

    FollowEnum(Integer code, String msg ) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }}
