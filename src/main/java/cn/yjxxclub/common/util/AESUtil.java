package cn.yjxxclub.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-10-28
 * Time: 下午2:31
 * Describe: AES Util
 */
public class AESUtil {

    private static String keys = "1234567890";

    /**
     * 加密
     * @param keys
     * @param content
     * @return
     */
    public static String encrypt(String keys, String content) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen=KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            keygen.init(128, new SecureRandom(keys.getBytes()));
            //3.产生原始对称密钥
            SecretKey secretKey = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] enCodeFormat = secretKey.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.根据密码器的初始化方式--加密：将数据加密
            byte[] result = cipher.doFinal(content.getBytes("utf-8"));
            //9.根据需要可以byte[] 转String
            return new String(new BASE64Encoder().encode(result));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 解密
     * @param kyes
     * @param content
     * @return
     */
    public static String decrypt(String kyes, String content) {
        try {
            KeyGenerator keygen=KeyGenerator.getInstance("AES");
            keygen.init(128, new SecureRandom(kyes.getBytes()));
            SecretKey original_key=keygen.generateKey();
            byte [] raw=original_key.getEncoded();
            SecretKey key=new SecretKeySpec(raw, "AES");
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            /*
             * 解密
             */
            byte [] byte_decode=cipher.doFinal(new BASE64Decoder().decodeBuffer(content));
            String AES_decode=new String(byte_decode,"utf-8");
            return AES_decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(encrypt(keys,"tengxing"));
        System.out.println(decrypt(keys,encrypt(keys,"tengxing")));
        /* 报错:
        fUymkcvG/XkSRaqyQsTbwg==
        javax.crypto.BadPaddingException: Given final block not properly padded
        null
        */
    }
}
