package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/18
 */
public class JiQiRenDeYunDongFanWeiLcof {

    /**
     * 指 Offer 13. 机器人的运动范围
     */

    /**
     * 深度优先遍历，由于是从(0,0)开始的，所以只需要考虑向右和向下的方向，该方法还可以将c变量去掉
     * 返回0/1即可
     */

    public static int movingCount(int m, int n, int k) {

        boolean[][] move = new boolean[m][n];
        return reMove(move, 0, 0, k, 0);
    }

    static int reMove(boolean[][] move, int i, int j, int k, int c){
        if (i < 0 || i >= move.length || j < 0 || j >= move[0].length || move[i][j]){
            return c;
        }
        int a = i;
        int b = j;
        int sum = 0;
        while (a > 0){
            sum += a % 10;
            a = a / 10;
        }
        while (b > 0){
            sum += b % 10;
            b = b / 10;
        }
        if (sum > k){
            return c;
        }
        c++;
        move[i][j] = true;
        c = reMove(move, i + 1, j, k, c);
        c = reMove(move, i, j + 1, k, c);
        return c;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(11,1,1));
    }
}
