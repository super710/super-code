package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/19
 */
public class ContainerWithMostWater {

    /**
     * 11. 盛最多水的容器
     */

    /**
     * 暴力法，两次循环数组，排除一些不可能出现的情况：由 1027 ms 降到 362 ms
     */

    public static int maxArea(int[] height) {
        int max = 0;
        int a;
        int m = 0;
        int n = 0;
        for (int i = 0; i < height.length; ++i) {
            if (height[i] <= m) {
                continue;
            }
            m = Math.max(m, height[i]);
            for (int j = height.length - 1; j >= i + 1; --j) {
                if (height[j] <= n) {
                    continue;
                }
                n = Math.max(n, height[j]);
                a = Math.min(height[i], height[j]);
                max = Math.max(a * (j - i), max);
            }
            n = 0;
        }
        return max;
    }

    /**
     * 双指针，指针中较小的那个不会成为新的边界，所以可以移动它，直至数组走完
     */
    public static int maxArea1(int[] height) {
        int max = 0;
        int m = 0;
        int n = height.length - 1;
        while (m < n) {
            if (height[m] <= height[n]){
                max = Math.max(height[m] * (n - m), max);
                m++;
            } else {
                max = Math.max(height[n] * (n - m), max);
                n--;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(maxArea1(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
