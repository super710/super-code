package 剑指Offer;

/**
 * @author Tiger
 * @date 2020/11/28 17:26
 */
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows;
        int columns;
        if (matrix == null || (rows = matrix.length) == 0 || (columns = matrix[0].length) == 0) {
            return false;
        }
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            }
            if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
