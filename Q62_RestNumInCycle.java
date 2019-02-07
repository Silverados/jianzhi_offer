package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/4 11:11
 */
public class Q62_RestNumInCycle {

    public static void main(String[] args){
        System.out.println(lastNum(5, 3));
    }

    /**
     * 0 ~ n-1 这 n 个数字排成一个圆圈，从数字 0 开始，每次移除第 m 个数字，求最后剩下的一个数字
     */
    public static int lastNum(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
