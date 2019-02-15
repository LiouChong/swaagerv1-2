package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * PlateRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class PlateRequest   {

    @ApiModelProperty("")
    private String plateName;



    public String getPlateName() {
    return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
        }


}