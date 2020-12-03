package Matrix;

import org.junit.Test;

/**
 * 顺时针打印矩阵，从外向里
 * 例如
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {

        if(matrix.length == 0) return new int[0];
        //行,列范围
        int rowStart = 0;
        int lineStart = 0;
        int rowEnd = matrix.length-1;
        int lineEnd=matrix[0].length-1;

        int res[] = new int[(rowEnd+1)*(lineEnd+1)];
        int x =0;

        int pointRow = 0;//行指针
        int pointLine = 0;//列指针

        while(rowStart<=rowEnd&&lineStart<=lineEnd){
            //输出第一行,遍历列
            while (pointLine<=lineEnd) {
                /*System.out.printf("%d", matrix[pointRow][pointLine]);
                System.out.printf("%c",',');*/
                res[x++]=matrix[pointRow][pointLine];
                pointLine++;
            }
            pointLine--;
            pointRow++;

            if(pointRow>rowEnd||pointLine>lineEnd||pointRow<rowStart||pointLine<lineStart)
                break;
            //输出末尾列
            while(pointRow<=rowEnd){
               /* System.out.printf("%d", matrix[pointRow][pointLine]);
                System.out.printf("%c",',');*/
                res[x++]=matrix[pointRow][pointLine];
                pointRow++;

            }
            pointRow--;
            pointLine--;

            if(pointRow>rowEnd||pointLine>lineEnd||pointRow<rowStart||pointLine<lineStart)
                break;

            //逆序输出末尾行
            while(pointLine>=lineStart){
               /* System.out.printf("%d", matrix[pointRow][pointLine]);
                System.out.printf("%c",',');*/
                res[x++]=matrix[pointRow][pointLine];
                pointLine--;
            }
            pointLine++;
            pointRow--;

            if(pointRow>rowEnd||pointLine>lineEnd||pointRow<rowStart||pointLine<lineStart)
                break;

            //逆序输出开始列
            while(pointRow>=rowStart+1){
                /*System.out.printf("%d", matrix[pointRow][pointLine]);
                System.out.printf("%c",',');*/
                res[x++]=matrix[pointRow][pointLine];
                pointRow--;
            }
            pointRow++;
            pointLine++;
            if(pointRow>rowEnd||pointLine>lineEnd||pointRow<rowStart||pointLine<lineStart)
                break;
            //范围缩减
            rowStart++;
            rowEnd--;
            lineStart++;
            lineEnd--;
        }
            return res;

    }

    @Test
    public void test1(){
        int[][] a={{1,2,3},{4,5,6}};
        int[] ints = spiralOrder(a);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
