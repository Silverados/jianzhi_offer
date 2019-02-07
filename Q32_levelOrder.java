package jianzhi_offer;

import java.util.*;

/**
 * @author weiyuwang
 * @since 2019/1/30 21:18
 */
public class Q32_levelOrder {
    /**
     * LeetCode 102
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = null;
        Deque<TreeNode> queue = new ArrayDeque<>();

        if (root == null) return result;
        queue.addFirst(root);
        while (!queue.isEmpty()) {

            temp = new ArrayList<>();
            int levelNum = queue.size();

            for (int i = 0; i < levelNum; i++) {
                root = queue.removeLast();
                temp.add(root.val);
                if (root.left != null) {
                    queue.addFirst(root.left);
                }
                if (root.right != null) {
                    queue.addFirst(root.right);
                }
            }
            result.add(temp);
        }
        return result;
    }

    /**
     * LeetCode 103
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
     * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        int level = 0;
        if (root == null) {
            return result;
        }
        queue.addFirst(root);
        while (!queue.isEmpty()) {

            temp = new ArrayList<>();
            int levelNum = queue.size();

            for (int i = 0; i < levelNum; i++) {
                root = queue.removeLast();
                temp.add(root.val);
                if (root.left != null) {
                    queue.addFirst(root.left);
                }
                if (root.right != null) {
                    queue.addFirst(root.right);
                }
            }
            level++;
            // 奇数从左到右 偶数从右到左

            if (level % 2 == 0) {
                Collections.reverse(temp);
            }
            result.add(temp);
        }
        return result;
    }

}
