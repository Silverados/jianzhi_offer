package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weiyuwang
 * @since 2019/2/2 16:57
 */
public class Q50_FirstAppearOnceCharacter {
    public static void main(String[] args){
        System.out.println(findChar1("abaccdeff"));
    }

    /**
     * 在字符串中第一个只出现一次的字符
     * @param str
     * @return
     */
    private static char findChar(String str) {
        if (str == null || str.length() == 0) {
            return '0';
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            int val = map.getOrDefault(c, 0);
            map.put(c, val + 1);
        }

        for (char c : str.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }

        return '0';
    }

    /**
     * 在字符流中第一个只出现一次的字符
     * @param str
     * @return
     */
    private static char findChar1(String str) {
        if (str == null || str.length() == 0) {
            return '0';
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], -1);
            } else {
                map.put(chars[i], i);
            }
        }


        // 遍历所有字符
        int minIndex = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                minIndex = Math.min(minIndex, entry.getValue());
            }
        }
        return chars[minIndex];
    }
}
