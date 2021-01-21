package offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author cy
 * @Description
 * @Date 2021/1/21
 */
public class DiYiGeZhiChuXianYiCiDeZiFuLcof {

    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     */

    /**
     * 从左右两边同时查找，如歌index一样则返回
     */

    public static char firstUniqChar(String s) {
        char[] split = s.toCharArray();
        for (int i = 0; i < split.length; i++) {
            if (s.lastIndexOf(split[i]) == i && s.indexOf(split[i]) == i) {
                return split[i];
            }
        }
        return ' ';
    }

    /**
     * 利用有序hashmap，进行查找
     */
    public static char firstUniqChar1(String s) {
        HashMap<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }

    /**
     * 直接利用hashmap进行查找，两次循环字符串s
     */
    public static char firstUniqChar2(String s) {
        HashMap<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
        System.out.println(firstUniqChar1("abaccdeff"));
        System.out.println(firstUniqChar2("abaccdeff"));
    }
}
