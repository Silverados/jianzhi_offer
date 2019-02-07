package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/29 22:09
 */
public class Q27_InvertTree {
    /**
     * LeetCode 226
     * 翻转一棵二叉树。
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}
