package jianzhi_offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author weiyuwang
 * @since 2019/2/1 16:34
 */
public class Q41_MedianFinder {
    /**
     * LeetCode 41
     *
     * 从数据流中获取中位数
     * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
     */
    class MedianFinder {

        /** initialize your data structure here. */

        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        }

        public void addNum(int num) {
            if(minHeap.size() == 0) {
                minHeap.add(num);
                return;
            }

            if(minHeap.size() == maxHeap.size()) {
                if(num > minHeap.peek()) {
                    minHeap.add(num);
                } else {
                    if(num < maxHeap.peek()) {
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(num);
                    } else {
                        minHeap.add(num);
                    }
                }
            } else {
                if(num > minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
            }
        }

        public double findMedian() {
            if(minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else {
                return minHeap.peek();
            }
        }
    }
}
