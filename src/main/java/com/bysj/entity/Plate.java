package com.bysj.entity;


import com.bysj.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 板块列表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class Plate extends BaseEntity {


private static final long serialVersionUID = 1L;

        @ApiModelProperty("")
    private String plateName;



    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }


        @Override
    public String toString() {
            return "Plate{" +
                                                                                            ", plateName=" + plateName +
                                                "}";
    }
    }