package jianzhi_offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author weiyuwang
 * @since 2019/2/2 10:38
 */
public class Q45_SortArrayAsMinNum {

    public static void main(String[] args){
        System.out.println(asMinNum(new int[]{3,32,321}));
    }

    /**
     * 输入正整数数组，把数组里的所有数字拼接起来排成一个数，返回拼接出来的所有数字中最小的一个。
     * @param nums
     * @return
     */
    public static String asMinNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        if (nums.length == 1) {
            return "" + nums[0];
        }

        Integer[] is = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            is[i] = nums[i];
        }
        Arrays.sort(is, new MyComparator());

        StringBuilder sb = new StringBuilder();
        for (Integer i : is) {
            sb.append(i);
        }
        return sb.toString();
    }

    static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            String as = new StringBuilder(b).append(a).toString();
            String bs = new StringBuilder(a).append(b).toString();
            return bs.compareTo(as);
        }
    }


}
