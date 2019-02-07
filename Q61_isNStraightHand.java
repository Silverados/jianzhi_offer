package jianzhi_offer;

import java.util.Arrays;

/**
 * @author weiyuwang
 * @since 2019/2/4 10:53
 */
public class Q61_isNStraightHand {
    public static void main(String[] args){
        System.out.println(isNStraightHand(new int[]{0, 0, 2, 5, 6}));
    }
    /**
     * 从扑克牌中随机抽 5 张牌，判断是不是一个顺子
     * 2~10 为数字本身，A 为 1，J 为 11，Q 为 12，K 为 13，大小王可以看成任意数字
     * @return
     */
    public static boolean isNStraightHand(int[] nums){
        Arrays.sort(nums);
        // 将大小王看成 0
        int zeroTimes = 0;
        for (int i = 0; i < nums.length && nums[i] == 0; i++) {
            zeroTimes++;
        }
        // 0 0 2 5 6
        int zeroGap = 0;
        for (int i = zeroTimes; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]){
                return false;
            }

            int val = nums[i + 1] - nums[i] - 1;
            zeroGap += val;
            if (zeroGap > zeroTimes) {
                return false;
            }
        }
        return zeroGap <= zeroTimes;
    }
}
