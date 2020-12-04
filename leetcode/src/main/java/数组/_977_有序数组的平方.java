package 数组;

import java.util.Arrays;

/**
 * @author Tiger
 * @date 2020/11/17 17:59
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class _977_有序数组的平方 {
    /**
     * 三指针
     * @param A
     * @return
     */
    public int[] sortedSquares1(int[] A) {
        int length = A.length;
        int[] ints = new int[length];
        for (int left=0,right=length-1,pos=length-1;pos>=0;pos--){
            int a =A[left]*A[left];
            int b =A[right]*A[right];
            if (a>=b){
                ints[pos] = a;
                left++;
            }else {
                ints[pos] =b;
                right--;
            }
        }
        return ints;
    }
}
