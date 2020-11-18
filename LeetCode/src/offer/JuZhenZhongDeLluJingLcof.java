package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/17
 */
public class JuZhenZhongDeLluJingLcof {

    /**
     * 剑指 Offer 12. 矩阵中的路径
     */

    /**
     * 针对每一个元素进行上下左右的深度遍历，如果word字符串被遍历完，即有该路径时，返回true
     */

    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; ++i){
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(board, words, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, char[] word, int i, int j, int k){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]){
            return false;
        }
        if (k == word.length - 1){
            return true;
        }
        board[i][j] = '\0';
        boolean b = dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1) ||
                    dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1);
        board[i][j] = word[k];
        return b;
    }
    public static void main(String[] args) {

        System.out.println(exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}}, "AAB"));
    }
}
