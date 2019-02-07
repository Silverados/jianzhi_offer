package jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weiyuwang
 * @since 2019/1/31 22:07
 */
public class Q38_permutations {
    /**
     * 《剑指offer》里是字母的全排列
     *
     * LeetCode 46
     *
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     */
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            if(nums == null || nums.length == 0){
                return res;
            }
            dfs(nums,0);
            return res;
        }

        public void dfs(int[] nums, int index){
            if(index == nums.length){
                List<Integer> list = new ArrayList<>();
                for(int num : nums){
                    list.add(num);
                }
                res.add(new ArrayList<Integer>(list));
            }

            for(int i = index;i < nums.length;i++){
                swap(nums,i,index);
                dfs(nums,index + 1);
                swap(nums,i,index);
            }
        }

        private void swap(int[] nums, int m, int n) {
            if(m == n){
                return;
            }
            int temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;
        }
    }
}
