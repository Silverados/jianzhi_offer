package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/2 11:08
 */
public class Q46_numDecodings {
    public static void main(String[] args){
        System.out.println(numDecodings("12258"));
    }

    /**
     * 注意在编码方式上剑指offer是从 0 开始
     *
     * LeetCode 91
     *
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     *
     */
    public static int numDecodings(String s) {
        // 寻找最优子结构和重叠子问题，以记忆化搜索或动态规划来解决
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ss = s.toCharArray();
        int len = ss.length;
        // res[i] 表示字符串中第 i 位数字与其之后数字的组成的编码总数
        int[] res = new int[len];
        if (ss[len - 1] != '0') {
            res[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            // '0' 需要与其前一位一起考虑，不单独考虑
            if (ss[i] == '0') {
                continue;
            }
            // 判断与后面的数字的组合是否小于 26
            if (ss[i] == '1' || (ss[i] == '2' && ss[i + 1] <= '6')) {
                if (i == len - 2) {
                    res[i] = res[i + 1] + 1;
                } else {
                    // 以 i 位数字开头的编码总和其实就是其后两位数字各自的编码之和
                    res[i] = res[i + 1] + res[i + 2];
                }
            } else {
                res[i] = res[i + 1];
            }
        }
        return res[0];
    }
}
