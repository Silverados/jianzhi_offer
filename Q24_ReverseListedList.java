package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/29 14:11
 */
public class Q24_ReverseListedList {

    /**
     * LeetCode 206
     * <p>
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode finalHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return finalHead;
    }

    /**
     * 这个容易理解一点
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        } else {
            ListNode cur = head;
            ListNode curNext = head.next;
            head = reverseList(head.next);
            curNext.next = cur;
            cur.next = null;
        }
        return head;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode pNext = head.next;
            head.next = prev;
            prev = head;
            head = pNext;
        }
        return prev;
    }
}
