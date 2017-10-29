package cn.yjxxclub.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-10-28
 * Time: 下午3:52
 * Describe: Date Util
 */
public class DateUtil {

    //默认格式,精确到秒
    public static String defaultSimpleFormater = "yyyy-MM-dd HH:mm:ss";
    //精确到日
    public static String daySimpleFormater ="yyyy-MM-dd";


    /**
     * 默认格式化
     * 1017-01-11 11:11:11
     * @return
     */
    public static String getDefaultFormater(){
        return new SimpleDateFormat(defaultSimpleFormater).format(new Date());
    }

    /**
     * 获取日期
     * 2017-10-10
     * @return
     */
    public static String getDateFormater(){
        return new SimpleDateFormat(daySimpleFormater).format(new Date());
    }

    /**
     * 获取年月
     * 201701
     * @return
     */
    public static String getYearAndMonth(){
        return new SimpleDateFormat("yyyyMM").format(new Date());
    }

    /**
     * 获取时间
     * 11:11:11
     * @return
     */
    public static String getTimeFormater(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void main(String[] args){
        System.out.println(getTimeFormater());
        System.out.println(getYearAndMonth());
        System.out.println(getDateFormater());
        System.out.println(getDefaultFormater());
        System.out.println(getTimeFormater());}
}
