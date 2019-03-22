package com.bysj.common.request;


/**
 * @auther: LiuChong
 * @date: 2018/11/21 15:42
 * @description: 基础实体
 */
public class BaseEntity {

    // 主键Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public String getStringId() {
        return id != null ? id.toString() : null;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
