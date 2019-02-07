package jianzhi_offer;

import java.util.Arrays;

/**
 * @author weiyuwang
 * @since 2019/2/3 11:20
 */
public class Q56_singleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[]{2, 2, 2, 3}));
    }

    /**
     * LeetCode 260
     * <p>
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
     * 找出只出现一次的那两个元素。
     */
    public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        int xor = 1;
        while ((a & 1) == 0) {
            a >>= 1;
            xor <<= 1;
        }

        for (int i : nums) {
            if ((i & xor) != 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }

        return res;
    }

    /**
     * LeetCode 137
     * <p>
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。
     * 找出那个只出现了一次的元素。
     */
    public static int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

    public static int singleNumber3(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            res |= (sum % 3) << i;
        }
        return res;
    }
}
