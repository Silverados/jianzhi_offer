package jianzhi_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 232
 *
 * @author weiyuwang
 * @since 2019/1/23 14:18
 */
public class Q9_UseStackRealizeQueue {
    /**
     * 用两个栈实现队列
     */
    class MyQueue {

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> sup = new ArrayDeque<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while(!stack.isEmpty()){
                sup.addFirst(stack.removeFirst());
            }

            sup.addFirst(x);

            while(!sup.isEmpty()){
                stack.addFirst(sup.removeFirst());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack.removeFirst();
        }

        /** Get the front element. */
        public int peek() {
            return stack.getFirst();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }


    /**
     * 用队列实现栈
     */
    class MyStack {

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> queue1 = new ArrayDeque<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            while(!queue.isEmpty()){
                queue1.addLast(queue.removeFirst());
            }
            queue.addLast(x);
            while(!queue1.isEmpty()){
                queue.addLast(queue1.removeFirst());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.removeFirst();
        }

        /** Get the top element. */
        public int top() {
            return queue.getFirst();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
