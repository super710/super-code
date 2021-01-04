package offer;

import java.util.*;

/**
 * @Author cy
 * @Description
 * @Date 2021/1/4
 */
public class ZiFuChuanDePaiLieLcof {

    /**
     * 剑指 Offer 38. 字符串的排列
     */

    /**
     * 深度优先遍历加剪枝，将每个字符和它后面的字符依次交换，遇到之前重复的直接
     * 跳过（剪枝）
     */
    static char[] chars;
    static List<String> strings;
    public static String[] permutation(String s) {
        chars = s.toCharArray();
        strings = new ArrayList<>();
        dfs(0);
        return strings.toArray(new String[0]);
    }
    static void dfs(int i){
        if (i == chars.length - 1){
            strings.add(String.valueOf(chars));
            return;
        }
        Set<Character> characters = new HashSet<>();
        for (int j = i; j < chars.length; j++) {
            if (characters.contains(chars[j])){
                continue;
            }
            characters.add(chars[j]);
            swap(j, i);
            dfs(i + 1);
            swap(j, i);
        }
    }
    static void swap(int a, int b){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abc")));
        System.out.println(Arrays.toString(permutation("abbc")));
    }
}
