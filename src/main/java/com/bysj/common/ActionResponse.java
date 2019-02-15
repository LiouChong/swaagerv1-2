package com.bysj.common;

/**
 *
 */
public class ActionResponse<T> {

    /**
     * 返回的头部信息
     */
    private Head head = new Head();

    /**
     * 返回主体信息
     */
    private Body body = new Body();

    public ActionResponse() {
    }

    /**
     * 构建默认的成功响应
     *
     * @param <T>
     * @return
     */
    public static <T> ActionResponse<T> success() {
        return new ActionResponse<T>(RespBasicCode.SUCCESS);
    }

    public static <T> ActionResponse<T> fail(RespBasicCode respCode) {
        return new ActionResponse<T>(respCode);
    }

    public static <T> ActionResponse<T> fail(RespBasicCode respCode, T result) {
        return new ActionResponse<T>(respCode, result);
    }

    public static <T> ActionResponse<T> success(T result) {
        return new ActionResponse<T>(RespBasicCode.SUCCESS, result);
    }

    public ActionResponse(RespBasicCode respCode) {
        super();
        this.head.setCode(respCode.getResultCode());
        this.head.setResult(respCode.getResultDes());
    }

    public ActionResponse(RespBasicCode respCode, T result) {
        super();
        this.head.setCode(respCode.getResultCode());
        this.head.setResult(respCode.getResultDes());
        this.body.setResult(result);
    }

    public ActionResponse(RespBasicCode respBasicCode, String msg, T result) {
        this.head.result = msg;
        this.head.code = respBasicCode.getResultCode();
        this.body.data = result;
    }

    public ActionResponse(String code, String msg, T result) {
        this.head.code = code;
        this.head.result = msg;
        this.body.data = result;
    }

    /**
     * 返回的实体信息
     */
    private class Body {

        public Body() {
        }

        /**
         * 数据域，如果是分页直接为，PageResult即可
         */
        private T data;

        public T getResult() {
            return data;
        }

        public void setResult(T result) {
            this.data = result;
        }
    }

    /**
     * 响应的头部
     */
    private class Head {
        public Head() {
        }

        /**
         * 状态码
         */
        private String code;

        /**
         * 状态码对象的结果
         */
        private String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public Head getHead() {
        return head;
    }


    public void setBody(T result) {
        this.body.data = result;
    }

    public T getBody() {
        return body.getResult();
    }
}
