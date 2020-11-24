package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/24
 */
public class ErWeiShuZuZhongDeChaZhaoLcof {

    /**
     * 剑指 Offer 04. 二维数组中的查找
     */

    /**
     * 从右上角或者左下角开始遍历查找
     */

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[n - 1][m - 1]){
            return false;
        }
        int row = 0, col = m - 1;
        while (row < n && col >= 0){
            if (target == matrix[row][col]){
                return true;
            } else if (target > matrix[row][col]){
                row++;
            }else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findNumberIn2DArray(new int[][]{{1, 4, 7, 11, 15}, {2,   5,  8, 12, 19},{3,   6,  9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
    }
}
