package offer;

import java.util.*;

/**
 * @Author cy
 * @Description
 * @Date 2021/1/14
 */
public class ShuJuLiuZhongDeZhongWeiShuLcof {

    /**
     * 剑指 Offer 41. 数据流中的中位数
     */

    /**
     * 直接在每次查找中位数的时候进行排序
     */

    static class MedianFinder {

        List<Integer> lists;
        public MedianFinder() {
            lists = new ArrayList<>();
        }

        public void addNum(int num) {
            lists.add(num);
        }

        public double findMedian() {
            lists.sort(Comparator.naturalOrder());
            if (lists.size() % 2 == 1){
                return lists.get(lists.size() / 2);
            } else {
                return (lists.get(lists.size() / 2) + lists.get(lists.size() / 2 - 1)) / 2.0;
            }
        }
    }

    /**
     * 利用大根堆和小根堆进行排序,参考答案
     */

    static class MedianFinder1 {

        Queue<Integer> min, max;
        public MedianFinder1() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (min.size() == max.size()){
                min.offer(num);
                max.offer(min.poll());
            } else {
                max.offer(num);
                min.offer(max.poll());
            }
        }

        public double findMedian() {
           if (min.size() == max.size()){
               //不会出现空指针情况
               return ((min.peek() + max.peek()) / 2.0);
           } else {
               //不会出现空指针情况
               return max.peek();
           }
        }
    }
    public static void main(String[] args) {
        MedianFinder1 medianFinder1 = new MedianFinder1();
        medianFinder1.addNum(1);
        medianFinder1.addNum(2);
        System.out.println(medianFinder1.findMedian());
        medianFinder1.addNum(2);
        System.out.println(medianFinder1.findMedian());
        MedianFinder1 medianFinder = new MedianFinder1();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
