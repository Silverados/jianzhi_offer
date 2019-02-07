package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/30 21:45
 */
public class Q33_BSTPostOrder {
    /**
     * 给定一个整数数组，判断该数组是否是二叉搜索树的后序遍历结果？是返回true，否则返回false。假设输入数组的任意两个数字都不相同。
     *
     * 例如：
     *
     * 给定nums = [5,7,6],
     *
     * 因为存在以6为根，5为左子树，7为右子树的二叉搜索树，所以返回true。
     * @param args
     */
    public static void main(String[] args){
        System.out.println(isPostOrder(new int[]{7,4,6,5}));
    }
    
    public static boolean isPostOrder(int[] nums){
        if (nums == null || nums.length <= 2){
            return true;
        }

        return isPostOrder(nums, 0,nums.length);
    }

    public static boolean isPostOrder(int[] nums, int start, int len){
      int root = nums[len - 1];

        int i = start;
        for (; i < len - 1; i++) {
            if (nums[i] > root) {
                break;
            }
        }


        int j = i;
        for (; j < len - 1; j++) {
            if (nums[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > start) {
            left = isPostOrder(nums, start, i - start);
        }

        boolean right = true;
        if (i < len - 1) {
            right = isPostOrder(nums, i, len - i - 1);
        }

        return left && right;
    }
}
