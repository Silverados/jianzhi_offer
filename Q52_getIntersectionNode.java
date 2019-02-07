package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/2 21:24
 */
public class Q52_getIntersectionNode {
    /**
     * LeetCode 160
     * 编写一个程序，找到两个单链表相交的起始节点。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        int aLen = 0, bLen = 0;

        while(curA != null){
            aLen++;
            curA = curA.next;
        }

        while(curB != null){
            bLen++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        int gap = Math.abs(aLen - bLen);

        if(aLen > bLen){
            for(int i = 0;i < gap;i++){
                curA = curA.next;
            }
        } else {
            for(int i = 0;i < gap;i++){
                curB = curB.next;
            }
        }

        while(curA != null && curB != null){
            if(curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }
}
