package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/2 12:55
 */
public class Q48_lengthOfLongestSubstring {
    /**
     * leetCode 3
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            // current index of character
            int[] index = new int[128];
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }
    }
}
