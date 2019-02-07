package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/1 22:32
 */
public class Q49_UglyNumber {
    /**
     * LeetCode 264
     *
     * 编写一个程序，找出第 n 个丑数。
     *
     * 丑数就是只包含质因数 2, 3, 5 的正整数。
     */
    class Solution {
        public int nthUglyNumber(int n) {
            if(n <= 0) {
                return 0;
            }
            int[] res = new int[n];
            res[0] = 1;
            int nextIndex = 1;

            int ugly2 = 0;
            int ugly3 = 0;
            int ugly5 = 0;

            while(nextIndex < n){
                int min = minNumber(res[ugly2]*2,res[ugly3]*3,res[ugly5]*5);
                res[nextIndex] = min;
                // System.out.println(min);
                while(res[ugly2] * 2 <= min){
                    ugly2++;
                }
                while(res[ugly3] * 3 <= min){
                    ugly3++;
                }
                while(res[ugly5] * 5 <= min){
                    ugly5++;
                }

                nextIndex++;
            }

            return res[nextIndex - 1];
        }

        public int minNumber(int a,int b,int c){
            int min = a > b ? b : a;
            return min > c ? c : min;
        }
    }
}
