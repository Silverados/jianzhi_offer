package jianzhi_offer;

/**
 * LeetCode 105
 *
 * @author weiyuwang
 * @since 2019/1/23 10:24
 */
public class Q7_RebuildBinaryTreeThroughPreAndIn {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        buildTree(pre,in);
    }

    /**
     * 根据前序和中序建立二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length || preorder.length < 1){
            return null;
        }

        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private static TreeNode build(int[] preorder,int[] inorder,int prestart,int preend,int instart,int inend){
        // System.out.println(""+prestart + preend + instart + inend);
        if(prestart > preend || instart > inend){
            return null;
        }else if(prestart == preend){
            return new TreeNode(preorder[prestart]);
        }else{
            TreeNode root = new TreeNode(preorder[prestart]);
            int rootIndex = find(preorder[prestart],inorder,instart,inend);
            if(rootIndex == -1){
                return null;
            }
            // System.out.println(""+prestart + preend + instart + inend+rootIndex);
            int leftLen = rootIndex - instart;
            int leftPreEnd = prestart + leftLen;
            root.left = build(preorder,inorder,prestart+1,leftPreEnd,instart,rootIndex-1);
            root.right = build(preorder,inorder,leftPreEnd+1,preend,rootIndex+1,inend);
            return root;
        }
    }

    private static int find(int val,int[] inorder,int instart,int inend){
        for(int i = instart;i <= inend;i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}
