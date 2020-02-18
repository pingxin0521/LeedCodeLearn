package test07;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-12
 **/
public class ContainerWithMostWater {
    public int maxArea(int[] a) {
        int max = 0;
        for(int i = 0, j = a.length - 1; i < j ; ){
            int minHeight = a[i] < a[j] ? a[i ++] : a[j --];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }
}
