package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/3 10:20
 */
public class Q54_kthSmallest {
    /**
     * 《剑指offer》是二叉搜索树的第 k 大节点
     * <p>
     *
     * LeetCode 230
     * <p>
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
     * <p>
     * 说明：
     * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
     */
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = kthSmallest(root.left, k);
        if (left != Integer.MIN_VALUE) {
            return left;
        }
        if (++count == k) {
            return root.val;
        }
        return kthSmallest(root.right, k);
    }
}
