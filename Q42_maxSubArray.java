package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/1 19:38
 */
public class Q42_maxSubArray {
    /**
     * LeetCode 53
     *
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            if(sum <= 0){
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            if(sum > maxSum){
                maxSum = sum;
            }
        }

        return maxSum;
    }
}
