package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author cy
 * @Description
 * @Date 2021/3/11
 */
public class ZuiChangBuZhongFuZiChuanLcof {

    /**
     * 剑指 Offer 48. 最长不含重复字符的子字符串
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     */

    /**
     * 暴力法 + hash
     */

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            Set<Character> chars1 = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (!chars1.add(chars[j])) {
                    break;
                }
            }
            max = Math.max(max, chars1.size());
        }
        return max;
    }

    /**
     * 动态规划 + hash
     */
    public static int lengthOfLongestSubstring1(String s) {
        int length = 0, dp = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer j = map.getOrDefault(chars[i], -1);
            if (dp < i - j){
                dp = dp + 1;
            } else {
                dp = i - j;
            }
            map.put(chars[i], i);
            length = Math.max(length, dp);
        }
        return length;
    }


        public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
    }
}
