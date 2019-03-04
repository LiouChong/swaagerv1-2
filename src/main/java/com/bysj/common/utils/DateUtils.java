package com.bysj.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 时间处理类
 * @Author: LiuChong
 * @date: 2018/10/30 14:49
 */
public class DateUtils {
    public static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
    public final static String DAY_END_FORMAT = "yyyy-MM-dd 23:59:59";
    public final static String WHOLE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String NO_TIME_FORMAT = "yyyy-MM-dd";
    public final static String NO_SEG_FORMAT = "yyyyMMdd";

    /**
     * 获得指定时间当天起点时间
     *
     * @param date
     * @return 2017-02-24 00:00:00 日期格式
     */
    public static Date getDayBegin(Date date) {
        DateFormat df = new SimpleDateFormat(NO_TIME_FORMAT);
        String dateString = df.format(date);
        try {
            return df.parse(dateString);
        } catch (ParseException e) {
            logger.error("getDayBegin方法调用失败，入参：{}", date, e);
            return date;
        }
    }

    /**
     * 获得指定时间当天终点时间
     *
     * @param date
     * @return 2017-02-24 23:59:59 日期格式
     */
    public static Date getDayEnd(Date date) {
        DateFormat df = new SimpleDateFormat(DAY_END_FORMAT);
        String dateString = df.format(date);
        try {
            df = new SimpleDateFormat(WHOLE_FORMAT);
            return df.parse(dateString);
        } catch (ParseException e) {
            logger.error("getDayEnd方法调用失败，入参：{}", date, e);
            return date;
        }
    }

    /**
     * 字符串转为date类型
     *
     * @param dateStr    时间字符串
     * @param dateFormat 时间format
     * @return
     */

    public static Date getDateFormat(String dateStr, String dateFormat) {
        if (dateStr == null || "".equals(dateStr)) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(dateFormat);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            logger.error("getDayBeginString方法调用失败，入参：{}", dateStr, e);
            return null;
        }
    }

    /**
     * 将时间按照指定格式返回字符串
     * @param dateFormat
     * @return
     */
    public static String getDataString(Date date, String dateFormat){
        DateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(date).toString();
    }
}
