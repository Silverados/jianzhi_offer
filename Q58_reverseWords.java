package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/3 20:54
 */
public class Q58_reverseWords {
    public static void main(String[] args){
        System.out.println(reverseString("abcdefg", 2));
    }
    /**
     * LeetCode 151
     *
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     */
    public String reverseWords(String s) {
        if(s == null) return "";
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.insert(0, str);
            if (!str.equals("")) {
                sb.insert(0, " ");
            }
        }

        return sb.toString().trim();
    }

    /**
     * 定义函数实现将字符串前面的 k 个字符移到字符串的尾部
     * @param str
     */
    public static String reverseString(String str, int k) {
        if (str == null || str.length() < k) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(reverse(str.substring(0, k))).append(reverse(str.substring(k, str.length()))).reverse();
        return sb.toString();
    }

    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }
}
