package jianzhi_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weiyuwang
 * @since 2019/1/30 19:02
 */
public class Q30_MinStack {
    /**
     * LeetCode 155
     *
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。
     */
    class MinStack {

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if(stack.isEmpty()){
                stack.push(x);
                minStack.push(x);
            } else {
                stack.push(x);
                int y = minStack.peek();
                if(y <= x){
                    minStack.push(y);
                } else {
                    minStack.push(x);
                }
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
