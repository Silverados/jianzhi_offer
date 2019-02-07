package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/23 22:57
 */
public class Q15_Count1 {
    public static void main(String[] args){
        System.out.println(count1(9));
    }

    /**
     * LeetCode 191
     * 输入一个整数，输出该数二进制表示中 1 的个数。
     * @param n
     * @return
     */
    private static int count(int n) {
//        System.out.println(Integer.toBinaryString(n));
        return Integer.bitCount(n);
    }

    /**
     * 把一个整数 -1 后和自身 &,得到的结果相当于把整数的二进制表示中最右边的 1 变成 0
     * @param n
     * @return
     */
    private static int count1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    /**
     * LeetCode 251
     * 判断一个数是否是 2 的幂
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if(n < 1){
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
