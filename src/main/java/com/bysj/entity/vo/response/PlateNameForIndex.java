package com.bysj.entity.vo.response;

/**
 * 描述:返回发帖页面的板块信息
 *
 * @author liuchong
 */
public class PlateNameForIndex {
    /**
     * 板块id
     */
    private Integer id;

    /**
     * 板块名称
     */
    private String platename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatename() {
        return platename;
    }

    public void setPlatename(String platename) {
        this.platename = platename;
    }
}
