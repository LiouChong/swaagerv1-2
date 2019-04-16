package com.bysj.entity.vo.response;

/**
 * 描述:
 *
 * @author liuchong
 */
public class AskHelpManageResponse {
    /**
     * 发送人名称
     */
    private String sendUsername;
    /**
     * 文章标题
     */
    private String message;
    /**
     * 发送时间
     */
    private String sendDate;

    /**
     * 帖子id
     */
    private Integer postId;

    public String getSendUsername() {
        return sendUsername;
    }

    public void setSendUsername(String sendUsername) {
        this.sendUsername = sendUsername;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendDate() {
        return sendDate.substring(0, sendDate.lastIndexOf("."));
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"sendUsername\":\"")
                .append(sendUsername).append('\"');
        sb.append(",\"message\":\"")
                .append(message).append('\"');
        sb.append(",\"sendDate\":\"")
                .append(sendDate).append('\"');
        sb.append(",\"postId\":")
                .append(postId);
        sb.append('}');
        return sb.toString();
    }
}
