package com.bysj.entity.vo.request;

import com.antiy.common.base.BasicRequest;
import io.swagger.annotations.ApiModelProperty;
import com.antiy.common.validation.ObjectValidator;
import com.antiy.common.exception.RequestParamValidateException;
/**
 * <p>
 * UserTeamRelRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class UserTeamRelRequest extends BasicRequest implements ObjectValidator{

    /**
     *  用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     *  讨论组id
     */
    @ApiModelProperty("讨论组id")
    private Integer teamId;


    public Integer getUserId() {
    return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
        }


    public Integer getTeamId() {
    return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
        }


    @Override
    public void validate() throws RequestParamValidateException {

    }

}