package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/31 21:07
 */
public class Q37_SerialTree {
    /**
     * LeetCode 297
     *
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在
     * 一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     *
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行
     * 逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     *
     */
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serHelper(root, res);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public void serHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        serHelper(root.left, sb);
        serHelper(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        int[] idx = new int[1];
        return desHelper(arr, idx);
    }

    private TreeNode desHelper(String[] arr, int[] idx) {
        if (idx[0] >= arr.length) {
            return null;
        }
        String val = arr[idx[0]];
        if ("null".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        idx[0]++;
        root.left = desHelper(arr, idx);
        idx[0]++;
        root.right = desHelper(arr, idx);
        return root;
    }
}
