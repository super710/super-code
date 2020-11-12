/**
 * @Author Jinshihong
 * @Date 2020/11/11 9:25
 * @Version 1.0
 */
public class offer_12 {

    public static void main(String[] args) {



        offer_12 o=new offer_12();
        char[][] board={{'a'}};
        String word="ab";
        o.exist(board,word);

    }


    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[0].length;j++)
            {
                if (DFS(board,i,j,words,0)) return true;
            }
        return false;

    }

    public boolean DFS(char[][] board,int i,int j,char[] words,int k){
        if (i<0||i>=board.length||j<0||j>=board[0].length||words[k]!=board[i][j])
            return false;
        if (k==words.length-1) return true;
        board[i][j]='\0';
        boolean res=DFS(board,i+1,j,words,k+1)||DFS(board,i-1,j,words,k+1)||
                    DFS(board,i,j+1,words,k+1)||DFS(board,i,j-1,words,k+1);
        board[i][j]=words[k];
        return res;

    }
}
