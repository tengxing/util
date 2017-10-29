package cn.yjxxclub.common.util;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-10-4
 * Time: 下午2:46
 * Describe:
 */
public class StringUtil {

    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0 || str.equals("") || str.equals("null"));
    }

    /**
     * @param str Stirng to be checked if it is empty
     * @return Returns true if |str| is empty or null
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * @param str String to be checked if it is not empty
     * @return Returns true if |str| is not empty or null
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
