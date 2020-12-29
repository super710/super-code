package Sort;

import java.util.Arrays;

/**
 * 二叉堆
 */
public class HeapOperator {

    /**
     * 上浮调整
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array){
        int childIndex = array.length-1;
        int parentIndex = (childIndex-1)/2;
        //temp保存插入的叶子结点值，用于最后的赋值。
        int temp = array[childIndex];

        while(childIndex > 0&& temp < array[parentIndex]){
            array[childIndex]=array[parentIndex];
            childIndex = parentIndex;
            parentIndex =(parentIndex-1)/2;
        }
        array[childIndex]=temp;
    }

    /**
     * 下沉调整
     * @param array   待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static  void downAdjust(int[] array, int parentIndex, int length){

        //temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex+1;

        while (childIndex<length){
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if(childIndex+1<length && array[childIndex+1]<array[childIndex])
                childIndex++;

            //如果父节点小于任何一个孩子的值，直接跳出
            if(temp <=array[childIndex])
                break;

            //无需真正的交换，单向赋值即可
            array[parentIndex]=array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 *childIndex+1;
        }

        array[parentIndex] = temp;

    }

    public static void buildHeap(int[] array){
        //从最后一个非叶子节点开始，依次下沉调整
        for(int i = array.length/2;i>=0;i--)
            downAdjust(array,i,array.length);
    }


    /**
     * 堆排序
     *
     * @param array 待调整的堆
     */
    public static void heapSort(int[] array) {
        // 1.把无序数组构建成二叉堆。
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        // 2.循环删除堆顶元素，移到集合尾部，调节堆产生新的堆顶。
        for (int i = array.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 下沉调整最大堆
            downAdjust(array, 0, i);
        }
    }


    public static void main(String[] args) {
//        int[] array =new int[]{1,3,2,6,5,7,8,9,10,0};
//        upAdjust(array);
//        System.out.println(Arrays.toString(array));

        int[] array =new int[]{7,1,3,10,5,2,8,9,6};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

}
