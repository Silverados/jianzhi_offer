package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weiyuwang
 * @since 2019/1/23 16:57
 */
public class Q10_Fibonacci {
    public static void main(String[] args){
        System.out.println(fibonacci(43));
        System.out.println(flog(100));
    }

    /**
     * LeetCode 70
     * 青蛙跳台阶：一只青蛙可以跳上 1 级台阶，也可以跳上 2 级台阶。求青蛙跳上一个 n 级台阶有多少种跳法
     * @param n
     * @return
     */
    private static int flog(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    /**
     * LeetCode 509
     * 斐波那契数列
     * @param n
     * @return
     */
    private static int fibonacci(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        for (int i = 2; i <= n; i++) {
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }
        return map.get(n);
    }
}
