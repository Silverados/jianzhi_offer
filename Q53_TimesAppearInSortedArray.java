package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/2 22:19
 */
public class Q53_TimesAppearInSortedArray {
    /**
     * 《剑指offer》中是统计排序数组中 target出现的次数
     * <p>
     * LeetCode 34   在排序数组中查找元素的第一个和最后一个位置
     * <p>
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        return new int[]{getPre(nums, target), getEnd(nums, target)};
    }

    public int getPre(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo] == target ? lo : -1;
    }

    public int getEnd(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1) + 1;
            if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return nums[lo] == target ? lo : -1;
    }

    /**
     * 《剑指offer》里是递增序列，
     * <p>
     * LeetCode 268
     * <p>
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     */
    public int missingNumber(int[] nums) {
        int sum = (nums.length) * (1 + nums.length) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public int missingNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] != mid) {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                }
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

            if (lo == nums.length) {
                return nums.length;
            }
        }

        return -1;
    }

    /**
     * 单调递增数组里每个元素整数且唯一。编写程序实现找出数组中任意一个数值等于其下标的元素
     */
    public int findNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] > mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
