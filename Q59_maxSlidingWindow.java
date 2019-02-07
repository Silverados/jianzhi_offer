package jianzhi_offer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author weiyuwang
 * @since 2019/2/3 21:21
 */
public class Q59_maxSlidingWindow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    /**
     * LeetCode 239
     * <p>
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        int[] res = new int[nums.length - k + 1];
        int index = 0, start = 0, end = k - 1;

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        } // 初始化优先队列

        while (end < nums.length) {
            res[index++] = queue.peek();
            if (end == nums.length - 1) break;

            //移动
            queue.remove(nums[start++]);
            queue.add(nums[++end]);
        }

        return res;

    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {

        if (k == 1 || nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = k - 1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        result[resultIndex++] = max;

        while (++end < nums.length) {
            int oldMax = max;
            if (nums[end] > max) {
                max = nums[end];
            }

            int oldStart = start;
            start += 1;
            if (oldMax == max && nums[oldStart] == max) {
                max = nums[start];
                for (int i = start; i <= end; i++) {
                    if (nums[i] > max) {
                        max = nums[i];
                    }
                }
            }
            result[resultIndex++] = max;
        }

        return result;
    }

    /**
     * 定义一个队列并实现函数max得到队列的最大值，
     * 要求函数max、push_back 和 pop_front时间复杂度O(1)
     */
    class MaxQueue {

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> helper = new ArrayDeque<>();

        public MaxQueue() {

        }

        public void push_back(int val) {
            queue.addLast(val);
            if (helper.isEmpty()) {
                helper.addLast(val);
            } else {
                if (val > helper.peek()) {
                    helper.addLast(val);
                } else {
                    helper.addLast(helper.peek());
                }
            }
        }

        public int pop_front() {
            helper.removeFirst();
            return queue.removeFirst();
        }

        public int getMax() {
            return helper.peek();
        }

    }

}
