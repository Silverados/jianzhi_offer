package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/23 10:04
 */
public class Q6_ReversePrintLinkedList {
    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        //1 2 3 4 5
        Node root = null;
        Node node = null;
        int[] nums = {1,2,3,4,5};
        for (int i = 0; i < nums.length; i++) {
            if (root == null) {
                root = new Node(nums[i]);
                node = root;
            } else {
                node.next = new Node(nums[i]);
                node = node.next;
            }

        }


        reversePrint(root);
    }

    /**
     * 从尾到头打印链表
     * @param root
     */
    private static void reversePrint(Node root) {
        if (root == null) {
            return;
        }
        if (root.next != null) {
            reversePrint(root.next);
        }
        System.out.println(root.val);
    }
}
