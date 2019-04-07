package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * UserBanResponse 响应对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class UserTeamDetailResponse extends BaseEntity {
    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}