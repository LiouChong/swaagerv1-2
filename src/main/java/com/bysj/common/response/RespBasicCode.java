package com.bysj.common.response;

/**
 * @description: 基本返回状态码, 系统需要自定义返回码继承此枚举即可
 *
 *               <pre>
 *               枚举B开头为Basic简称为基础定义的状态码
 *               </pre>
 *
 * @Author: Liuchong
 * @date: 2018/10/30 13:30
 */
public enum RespBasicCode {
    SUCCESS("200", "成功"),
    PARAMETER_ERROR("400", "参数异常"),
    NOT_PERMISSION("403", "没有权限"),
    ERROR("500", "异常错误"),
    BUSSINESS_EXCETION("401","业务异常"),
    METHOD_NOT_ALLOWED("415","方法不允许"),
    BAD_REQUEST("400", "无效的请求"),
    NOT_FOUND("404", "资源不存在"),
    UNSUPPORTED_MEDIA_TYPE("415", "不支持的媒体类型");
    /**
     * 返回状态码
     */
    private String resultCode;

    /**
     * 返回描述
     */
    private String resultDes;

    RespBasicCode(String resultCode, String resultDes) {
        this.resultCode = resultCode;
        this.resultDes = resultDes;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultDes() {
        return resultDes;
    }

    /**
     * 通过code 获取异常对象
     *
     * @param code
     * @return
     */
    public static RespBasicCode getByCode(String code) {
        if (code == null || "".equals(code)) {
            return null;
        }
        for (RespBasicCode respBasicCode : RespBasicCode.values()) {
            if (respBasicCode.getResultCode().equals(code)) {
                return respBasicCode;
            }
        }
        return RespBasicCode.SUCCESS;
    }
}
