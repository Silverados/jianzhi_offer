package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/23 20:26
 */
public class Q11_RotateArrayMinNum {
    public static void main(String[] args){
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(findMin(arr));
    }

    /**
     * LeetCode 153
     *
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 请找出其中最小的元素。
     * 你可以假设数组中不存在重复元素。
     *
     * @param nums
     * @return
     */
    private static int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int lo = 0;
        int hi = nums.length - 1;

        if(nums[lo] < nums[hi]){
            return nums[lo];
        }

        while(lo < hi-1){
            int mid = lo + ((hi - lo) >> 1);
            if(nums[lo] < nums[mid]){
                lo = mid;
            }else{
                hi = mid;
            }
        }

        return nums[hi];
    }

    /**
     * LeetCode 154
     *
     * 续上，数组中的数字可能出现重复。
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int lo = 0;
        int hi = nums.length - 1;

        if(nums[lo] < nums[hi]){
            return nums[lo];
        }

        while(lo < hi-1){
            int mid = lo + ((hi - lo) >> 1);
            if(nums[lo] < nums[mid]){
                lo = mid;
            }else if(nums[lo] > nums[mid]){
                hi = mid;
            }else{
                return findMin(nums,lo,hi);
            }
        }

        return nums[hi];
    }

    public int findMin(int[] nums,int lo,int hi){
        int min = nums[lo];
        for(int i = lo + 1;i <= hi;i++){
            min = Math.min(min,nums[i]);
        }
        return min;
    }
}
