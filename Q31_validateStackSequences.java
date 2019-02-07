package jianzhi_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weiyuwang
 * @since 2019/1/30 21:16
 */
public class Q31_validateStackSequences {
    /**
     * LeetCode 946
     *
     * 给定 pushed 和 popped 两个序列，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，
     * 返回 true；否则，返回 false 。
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0 && popped.length == 0){
            return true;
        }

        if(pushed.length == 0 || popped.length == 0 || pushed.length != popped.length){
            return false;
        }


        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while(!stack.isEmpty() || i < pushed.length && j < popped.length){
            if (!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            } else if(!stack.isEmpty() && i == pushed.length && stack.peek() != popped[j] ){
                return false;
            } else if(pushed[i] != popped[j]){
                stack.push(pushed[i]);
                i++;
            } else {
                i++;
                j++;
            }
        }

        return j == popped.length;
    }

}
