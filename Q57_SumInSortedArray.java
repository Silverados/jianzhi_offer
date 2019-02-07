package jianzhi_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weiyuwang
 * @since 2019/2/3 20:20
 */
public class Q57_SumInSortedArray {
    public static void main(String[] args){
        for (int[] ints : find(9)) {
            System.out.println(Arrays.toString(ints));
        }
    }
    /**
     * LeetCode 167
     *
     * 输入一个递增排序的数组和一个数字 k，在数组中查找两个数，使得他们的和为 k。输入任意一对。
     */
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) {
            return null;
        }
        int i = 0,j = numbers.length - 1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[]{i + 1,j + 1};
            }else if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }

    /**
     * 输入正数 target，输出所有和为 target的连续正数序列 例如：输入9=2+3+4=4+5
     */
    public static List<int[]> find(int target) {
        List<int[]> list = new ArrayList<>();
        int small = 1;
        int big = 2;
        int mid = (target + 1) / 2;

        while (small < mid) {
            int sum = 0;
            for (int i = small; i <= big; i++) {
                sum += i;
            }

            if (sum == target) {
                list.add(new int[]{small,big});
                small++;
            } else if (sum < target) {
                big++;
            } else {
                small++;
            }
        }

        return list;
    }
}
