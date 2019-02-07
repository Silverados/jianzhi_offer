package jianzhi_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weiyuwang
 * @since 2019/2/2 17:41
 */
public class Q51_InversePairs {
    /**
     * 《剑指offer》是求数组中逆序对的个数
     *
     * LeetCode 315
     *
     * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     *
     * 示例:
     *
     * 输入: [5,2,6,1]
     * 输出: [2,1,1,0]
     *
     * 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，
     * 则其为一个逆序对；否则不是。
     */
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] result = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

            int start = 0;
            int end = list.size();

            while (start < end) {
                int middle = start + (end - start) / 2;
                //判断中间的数
                if (list.get(middle) < nums[i]) {
                    start = middle + 1;
                } else {
                    end = middle;
                }
            }
            result[i] = start;
            // 将每个数插入到list中//使用二分查找
            list.add(start, nums[i]);
        }
        return Arrays.asList(result);
    }
}
