package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/24 18:50
 */
public class Q16_Pow {
    public static void main(String[] args){

    }

    /**
     * LeetCode 50
     *
     * 实现 pow 求幂函数
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1/x * myPow(1/x, -(n+1));
        }
        if (n == 1) {
            return x;
        }
        if (n == 2) {
            return x*x;
        }

        int absN = n;

        return ((n & 0x1) == 0) ? myPow(myPow(x, n>>1),2):x*myPow(myPow(x, n>>1),2);

    }
}
