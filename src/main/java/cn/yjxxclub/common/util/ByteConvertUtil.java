package cn.yjxxclub.common.util;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-9-14
 * Time: 下午9:48
 * Describe: 二进制和其他类型（short,char,int,long,float,double,string）转换工具类
 */
public class ByteConvertUtil {

    public static byte[] short2byte(short i)
    {
        byte[] b = new byte[2];
        short2byte(i, b, 0);
        return b;
    }

    public static void short2byte(short n, byte[] buf, int offset)
    {
        buf[offset] = (byte) (n >> 8);
        buf[offset + 1] = (byte) n;
    }

    public static short byte2short(byte[] b)
    {
        return byte2short(b, 0);
    }

    public static short byte2short(byte[] b, int offset)
    {
        return (short) (b[offset + 1] & 0xff | (b[offset + 0] & 0xff) << 8);
    }

    public static byte[] int2byte(int n)
    {
        byte[] b = new byte[4];
        int2byte(n, b, 0);
        return b;
    }

    public static void int2byte(int n, byte[] buf, int offset)
    {
        buf[offset] = (byte) (n >> 24);
        buf[offset + 1] = (byte) (n >> 16);
        buf[offset + 2] = (byte) (n >> 8);
        buf[offset + 3] = (byte) n;
    }

    public static int byte2int(byte b[])
    {
        return byte2int(b, 0);
    }

    public static int byte2int(byte b[], int offset)
    {
        return b[offset + 3] & 0xff | (b[offset + 2] & 0xff) << 8
                | (b[offset + 1] & 0xff) << 16 | (b[offset] & 0xff) << 24;
    }

    public static byte[] long2byte(long n)
    {
        byte[] b = new byte[8];
        long2byte(n, b, 0);
        return b;
    }

    public static void long2byte(long n, byte[] buf, int offset)
    {

        buf[offset] = (byte) (n >> 56);
        buf[offset + 1] = (byte) (n >> 48);
        buf[offset + 2] = (byte) (n >> 40);
        buf[offset + 3] = (byte) (n >> 32);
        buf[offset + 4] = (byte) (n >> 24);
        buf[offset + 5] = (byte) (n >> 16);
        buf[offset + 6] = (byte) (n >> 8);
        buf[offset + 7] = (byte) n;

    }

    /**
     * 拷贝字符串src的len个字节的长度，如果len<src.lenght()则拷贝部分 ，如果len>=src.length()全拷
     */
    public static byte[] getBytes(String src, int len)
    {

        byte[] buf = new byte[len];
        byte[] temp = src.getBytes();
        if (len > temp.length)
        {
            System.arraycopy(temp, 0, buf, 0, temp.length);
        }
        else
        {
            System.arraycopy(temp, 0, buf, 0, len);
        }
        return buf;
    }


    public static byte[] getBytes(String[] src, int len)
    {

        byte[] buf = new byte[len * src.length];
        for (int i = 0; i < src.length; i++)
        {
            byte[] temp = src[i].getBytes();
            System.arraycopy(temp, 0, buf, i * len, temp.length);
        }
        return buf;
    }

}

