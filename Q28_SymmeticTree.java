package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/29 23:03
 */
public class Q28_SymmeticTree {
    /**
     * LeetCode 28
     * 给定一个二叉树，检查它是否是镜像对称的。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            return true;
        }

        if(root.left == null || root.right == null){
            return false;
        }

        if(serial(root).equals(serial1(root))){
            return true;
        }

        return false;
    }

    public String serial(TreeNode root){
        if(root == null){
            return "#";
        }

        return root.val + "_" + serial(root.left) + "_" + serial(root.right);
    }

    public String serial1(TreeNode root){
        if(root == null){
            return "#";
        }

        return root.val + "_" + serial1(root.right) + "_" + serial1(root.left);
    }
}
