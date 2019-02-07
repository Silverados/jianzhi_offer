package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/29 21:25
 */
public class Q26_SubTree {
    /**
     * LeetCode 572
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树
     * 包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null){
            return true;
        }

        if(s == null && t != null){
            return false;
        }

        if(s != null && t == null){
            return false;
        }

        String ss = serial(s);
        String ts = serial(t);
        // System.out.println(serial(s));
        // System.out.println(serial(t));
        int val = ss.indexOf(ts);

        if(val == -1){
            return false;
        }

        if(val - 1 >= 0){
            char ch = ss.charAt(val - 1);
            if( ch != '_') return false;
        }

        return true;
    }

    public String serial(TreeNode s){
        if(s == null){
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.val);


        sb.append('_').append(serial(s.left));



        sb.append('_').append(serial(s.right));


        return sb.toString();
    }


    /**
     * 递归
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        boolean result = isSameTree(s, t);
        return result || isSubtree1(s.left, t) || isSubtree1(s.right, t);
    }
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        if(s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
