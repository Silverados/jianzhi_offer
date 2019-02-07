package jianzhi_offer;

import java.util.Arrays;

/**
 * @author weiyuwang
 * @since 2019/1/22 19:39
 */
public class Q3_FindDuplicatedNumInArray {
    public static void main(String[] args){
        int[] ints = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(find1(ints));
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(find2(arr));
    }

    /**
     * 长度为 n 的数组所有数字都在 0 ~ n-1 范围内。数组中某些数字重复，但是不知道哪些数字重复，也不知道
     * 重复几次。找出数组中任意一个重复的数字。
     *
     * 解法一：用映射(或者等长数组)统计各个元素的个数，找出其中一个元素个数 >1 的
     * 解法二：对数组进行排序，遍历数组，找出第一个元素和后面元素相等的
     * 解法三：如下代码
     * @param ints
     * @return
     */
    private static int find1(int[] ints) {

        //确保输入有效
        if (ints == null || ints.length <= 1) {
            return -1;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] < 0 || ints[i] > ints.length - 1) {
                return -1;
            }
        }

        int len = ints.length;
        for (int i = 0; i < ints.length; ) {
            if (ints[i] != i){
                if (ints[i] != ints[ints[i]]){
                    exch(ints,i,ints[i]);
                }else{
//                    System.out.println(Arrays.toString(ints));
                    return ints[i];
                }
            }else {
                i++;
            }
        }
        return -1;
    }

    /**
     * 在长度为 n+1 的数组里的所有数字都在 1~n 范围内，所以数组中至少有一个数组是重复的，找出数组中
     * 重复的一个数字，要求不能修改输入的数组。
     *
     * 解法一：用映射(或者等长数组)统计各个元素的个数，找出其中一个元素个数 >1 的
     * 解法二：把 1~n 的数字从中间数字 m 分为两部分 1~m 和 m+1~n,如果区间个数大于范围即说明该区间内
     *        存在重复数字。当范围为 1 时个数仍然 >1 说明重复。
     * @param ints
     * @return
     */
    private static int find2(int[] ints) {
        //确保输入有效
        if (ints == null || ints.length <= 1) {
            return -1;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] < 1 || ints[i] > ints.length - 1) {
                return -1;
            }
        }

        int len = ints.length;
        int start = 1;
        int end = len - 1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int count = countRange(ints, start, mid);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int countRange(int[] ints, int start, int end) {
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] >= start && ints[i] <= end) {
                count++;
            }
        }
        return count;
    }

    private static void exch(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
