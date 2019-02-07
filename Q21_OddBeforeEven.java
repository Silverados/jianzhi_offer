package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/29 00:07
 */
public class Q21_OddBeforeEven {
    /**
     * LeetCode 905
     * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int oddIdx = A.length - 1, evenIdx = 0;
        while(evenIdx < oddIdx) {
            if(A[evenIdx] % 2 != 0) {
                int t = A[evenIdx];
                A[evenIdx] = A[oddIdx];
                A[oddIdx--] = t;
            }
            else {
                evenIdx++;
            }
        }
        return A;
    }
}
