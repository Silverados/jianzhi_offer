package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/31 17:08
 */
public class Q35_copyRandomList {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }

        ;
    }

    /**
     * LeetCode 138
     *
     * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
     *
     * 要求返回这个链表的深度拷贝。
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            } else {
                cur.next.random = null;
            }

            cur = cur.next.next;
        }

        // 不能修改原链表
//         RandomListNode newHead = head.next;
//         RandomListNode newCur = newHead;

//         while(newCur != null){
//             if(newCur.next != null){
//                 newCur.next = newCur.next.next;
//             }else{
//                 newCur.next = null;
//             }
//             newCur = newCur.next;
//         }

//         return newHead;

        RandomListNode newHead = head.next;
        RandomListNode newCur = newHead;
        cur = head;

        while (cur != null) {
            RandomListNode node = cur.next;
            if (node != newHead) {
                newCur.next = node;
                newCur = newCur.next;
            }
            cur.next = cur.next.next;
            cur = cur.next;
        }

        return newHead;

    }
}
