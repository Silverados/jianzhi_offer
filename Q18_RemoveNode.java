package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/25 01:42
 */
public class Q18_RemoveNode {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * LeetCode 237
     * <p>
     * 删除节点(非尾结点)
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 这个节点是带删除节点的前一个结点
     *
     * @param node
     */
    public void deleteNode1(ListNode head, ListNode node) {
        if (node.next != null) {
            deleteNode(node);
        } else {
            ListNode pre = head;
            while (pre.next != node) {
                pre = pre.next;
            }
            pre.next = node.next;
        }
    }

    /**
     * LeetCode 83
     * <p>
     * 删除链表中重复的结点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * LeetCode 82
     * <p>
     * 书里描述的是这个：给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            // System.out.println(fast.val);
            if (fast.val != slow.val) {
                if (slow.next != fast) {
                    slow.val = fast.val;
                    slow.next = fast.next;
                    fast = fast.next;
                } else {
                    fast = fast.next;
                    slow = slow.next;
                }

            } else {
                fast = fast.next;
                if (fast == null) {
                    ListNode pre = result;
                    while (pre.next != slow) {
                        pre = pre.next;
                    }
                    pre.next = null;
                }
            }
        }

        return result.next;
    }
}
