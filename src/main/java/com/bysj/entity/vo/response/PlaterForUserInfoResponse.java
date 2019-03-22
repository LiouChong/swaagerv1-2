package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;

/**
 * <p>
 * PlaterResponse 响应对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class PlaterForUserInfoResponse extends BaseEntity {
    private String nickname;

    private String plateName;

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"plateName\":\"")
                .append(plateName).append('\"');
        sb.append('}');
        return sb.toString();
    }
}