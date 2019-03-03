package com.bysj.common.utils;

import com.bysj.common.exception.BussinessException;
import com.bysj.common.response.RespBasicCode;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @Author: 刘冲
 * @Description: 将实体类中的数字转化为中文字符，一般用于返回类
 * @Date: 2019/3/2 23:04
 */
@Component
public class NumberChineseEx<T> {

    /**
     * @TODO:考虑项目后期存储到redis中。
     * 通过ApiModelProperty上的注解将数字与中文相互转换，然后返回到前端。
     * @注意： 这里要求ApiModelProperty的格式为: 属性:1 说明,2 说明
     * @param t 需要转换的实体
     * @param fieldName 转换的属性
     */
    public String NumExchangeChinese(T t, String fieldName) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            //如果拿到想要转换的属性
            if (field.getName().equals(fieldName)) {
                try {
                    field.setAccessible(true);
                    Integer fieldValue = (Integer)field.get(t);

                    ApiModelProperty annotation = field.getAnnotation(ApiModelProperty.class);
                    //获得关联内容，格式为 1 有效,0 无效
                    String numChineseRel = annotation.value().split(":")[1];

                    //获取到一个关联的组合数组。
                    String[] oneRel = numChineseRel.split(",");
                    //s 格式则为 "1 有效"
                    for (String s : oneRel) {
                        Integer number = Integer.valueOf(s.split(" ")[0]);

                        //若属性的值为反射得到的数字，则将返回数字对应的中文。
                        if (number.equals(fieldValue)) {
                            return s.split(" ")[1];
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        throw new BussinessException(RespBasicCode.NOT_FOUND.getResultCode(),"返回参数数字转中文时发生错误！");
    }
}
