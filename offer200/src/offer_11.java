/**
 * @Author Jinshihong
 * @Date 2020/11/10 9:44
 * @Version 1.0
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class offer_11 {


    public int minArray(int[] numbers) {
        int min=numbers[0];   //0 1 2 3   //   len:4
        for (int i=1;i<numbers.length;i++){
           if (numbers[i]<min)
           {
               min=numbers[i];
               break;
           }
        }

        return min;
    }

//    二分search
    public int minArray2(int[] numbers) {
        int low=0;
        int high=numbers.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if (numbers[mid]>numbers[high])
                low=mid+1;//mid 不可能是最小的所以可以直接跳过
            else if (numbers[mid]<numbers[high])
                high=mid;//mid有可能是最小的   所以不能跳过
            else
                high--; //如果有重复的数字  最后的指针向前移动  避开重复数字的情况  不用考虑这个数是最小的 应为不是唯一的与题干

        }

        return numbers[low];

    }

}





















