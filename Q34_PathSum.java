package jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weiyuwang
 * @since 2019/1/31 17:05
 */
public class Q34_PathSum {
    /**
     * LeetCode 113
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     */
    class Solution {
        // 负数不知道要不要考虑

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) {
                return res;
            }
            List<Integer> list = new ArrayList<>();
            helper(root, sum, 0, list);
            return res;
        }

        public void helper(TreeNode root, int sum, int now, List<Integer> list) {
            // System.out.println(now);
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                //判断 叶子结点
                if (now + root.val == sum) {
                    list.add(root.val);
                    res.add(new ArrayList<Integer>(list));
                    list.remove(list.size() - 1);
                    return;
                } else {
                    return;
                }
            }

            list.add(root.val);

            helper(root.left, sum, now + root.val, list);

//         list.remove(list.size() - 1);

//         list.add(root.val);

            helper(root.right, sum, now + root.val, list);

            list.remove(list.size() - 1);
        }
    }
}