package cn.yjxxclub.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-10-14
 * Time: 下午9:35
 * Describe: Base64加密工具类
 */
public class Base64Util {

    /**
     * 加密
     * @param str
     * @return
     */
    public static String encrypt(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    /**
     * 解密
     * @param s
     * @return
     */
    public static String decrypt(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * 测试主函数
     * @param args
     */
    public static void main(String args[]){
        System.out.println(encrypt("github.com/tengxing"));
        System.out.println(decrypt(encrypt("github.com/tengxing")));
    }
}
