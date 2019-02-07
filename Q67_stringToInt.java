package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/5 23:13
 */
public class Q67_stringToInt {
    /**
     * LeetCode 8.
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     *
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     *
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     *
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     *
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * atoi
     */
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();

        // 丢弃 开头的空白字符
        int i = 0;
        for (; i < chars.length && chars[i] == ' '; i++) {
        }

        if(i == chars.length){
            return 0;
        }

        // 不是数字、正负号
        boolean isNeg = false;

        if (chars[i] == '-') {
            isNeg = true;
            i++;
        } else if (chars[i] == '+') {
            i++;
        } else if (!('0' <= chars[i] && chars[i] <= '9')){
            return 0;
        }

        // 首位必定为数字
        for (; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                sb.append(chars[i]);
            } else {
                break;
            }
        }

        // nums纯数字
        String nums = sb.toString();
        long res = 0L;

        int len = nums.length();
        for (int j = 0; j < len; j++) {
            res += (nums.charAt(j) - '0') * Math.pow(10, len - 1 - j);
        }

        if (isNeg) {
            res *= -1;
        }

        // System.out.println(res);

        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) res;
        }
    }
}
