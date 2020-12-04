package 栈_队列;

import java.util.Stack;

/**
 * @author Tiger
 * @date 2020/11/13 21:19
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid1("(){}[]"));
    }

    public static boolean isValid1(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValid2(String s) {
        Stack<Character> characterStack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if ('(' == c || '[' == c || '{' == c) {
                characterStack.push(c);
            } else {
                if (characterStack.empty()) {
                    return false;
                }
                Character pop = characterStack.pop();
                if ('(' == pop && ')' != c) {
                    return false;
                }
                if ('[' == pop && ']' != c) {
                    return false;
                }
                if ('{' == pop && '}' != c) {
                    return false;
                }
            }
        }
        return characterStack.empty();
    }

}
