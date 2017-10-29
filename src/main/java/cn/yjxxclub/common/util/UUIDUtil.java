package cn.yjxxclub.common.util;

import java.util.UUID;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-10-5
 * Time: 上午11:06
 * Describe:UUID 工具类
 */
public class UUIDUtil {

    /**
     * 获取UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
    public static void main(String[] args){
        System.out.println(getUUID());
    }
}
