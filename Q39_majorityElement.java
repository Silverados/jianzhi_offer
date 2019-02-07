package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/1 10:41
 */
public class Q39_majorityElement {
    /**
     * LeetCode 39
     *
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     */
    public int majorityElement(int[] nums) {
        //假设数组是非空的，并且给定的数组总是存在众数。

        int res = nums[0];
        int times = 1;
        boolean first = true;
        for(int num : nums){
            if(first){
                first = false;
                continue;
            }
            if(times == 0){
                res = num;
                times = 1;
            } else if(num == res){
                times++;
            } else {
                times--;
            }
        }

        return res;
    }
}
