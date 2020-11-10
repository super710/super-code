package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/10
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 3.无重复字符的最长子串
     */

    /**
     * 使用HashMap将字符作为key，index作为value，将字符串s循环放入map中，当发现map中存在key时
     * 并且对应的下标大于j时，说明字符串重复，此时重新计算不重复字符串的长度，选取最长的长度输出
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        //初始化无重复字符的最长子串长度为0，重复位置坐标为-1
        int len = 0, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            char a = s.charAt(i);
            //将重复的key对应的index和j的值相比，选择较大的值赋给j
            if (map.containsKey(a)) {
                j = Math.max(j, map.get(a));
            }
            //将字符放入map，重复的key值放入新的下标
            map.put(s.charAt(i), i);
            //每次计算子串的长度，并保存最长的长度
            len = Math.max(len, i - j);
        }
        return len;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abbadcsab"));
    }
}
