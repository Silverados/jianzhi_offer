package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/23 13:33
 */
public class Q8_NextNodeInBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.parent = root;
        root.right = new TreeNode(3);
        root.right.parent = root;


        getNext(root, 2);
    }

    /**
     * 中序遍历，结点有父指针。给一个结点求下个结点
     *
     * 解法一：直接用变量记录上一次遍历的结点，该结点和目标结点一致的话返回当前结点
     * @param root
     * @param i
     * @return
     */
    private static TreeNode getNext(TreeNode root, int i) {
        /*todo*/
        return null;
    }
}
