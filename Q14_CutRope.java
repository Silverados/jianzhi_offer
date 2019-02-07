package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/23 22:13
 */
public class Q14_CutRope {
    public static void main(String[] args) {
        System.out.println(cut(8));
    }

    /**
     * 将长度为 n 的绳子，剪成 m 段(m,n 都是整数，n > 1, m > 1),每段长度相乘的最大乘积是？
     *
     * @param n
     * @return
     */
    private static int cut(int n) {
        if (n < 2) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;

        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 0; j <= i / 2; j++) {
                int ans = res[j] * res[i - j];
                if (max < ans) {
                    max = ans;
                }
                res[i] = max;
            }
        }

        return max;
    }

    /**
     * 贪心策略：当 n >= 5时，尽可能多的剪长度为3的绳子；当剩下绳子长度为 4 时，剪成 2段长度为 2
     *
     * @param n
     * @return
     */
    private static int cut1(int n) {
        if (n < 2) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        int timeOf3 = n / 3;

        if (n - timeOf3 * 3 == 1) {
            timeOf3 -= 1;
        }

        int timeOf2 = (n - timeOf3 * 3) / 2;

        return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));
    }
}
