package 字符串;

/**
 * @author Tiger
 * @date 2020/11/27 8:00
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class _242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[] sInts = new int[26];

        for (char sChar : sChars) {
            ++sInts[sChar - 'a'];
        }
        for (char tChar : tChars) {
            if (--sInts[tChar - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
