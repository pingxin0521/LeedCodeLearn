package leetcode.week01.day07;

/**
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day07
 * hyp create at 20-3-18
 **/
public class CanThreePartsEqualSum {
    //数组元素的总和 sum 不是3的倍数，直接返回false
    //使用双指针left，right, 从数组两头开始一起找，节约时间
    //当 left + 1 < right 的约束下，可以找到数组两头的和都是 sum/3,那么中间剩下的元素和就一定也是sum/3
    //（left + 1 < right的约束就是要中间有剩下的元素，使用left < right的约束，数组可能可以恰好被划分成两部分，中间没有元素）
    public boolean canThreePartsEqualSum(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        if (sum % 3 != 0) {
            // 总和不是3的倍数，直接返回false
            return false;
        }

        // 使用双指针,从数组两头开始一起找，节约时间
        int left = 0;
        int leftSum = a[left];
        int right = a.length - 1;
        int rightSum = a[right];

        // 使用left + 1 < right 的原因，防止只能将数组分成两个部分
        // 例如：[1,-1,1,-1]，使用left < right作为判断条件就会出错
        int s = sum / 3;
        while (left + 1 < right) {
            if (leftSum == s && rightSum == s) {
                // 左右两边都等于 sum/3 ，中间也一定等于
                return true;
            }
            if (leftSum != s) {
                // left = 0赋予了初值，应该先left++，在leftSum += A[left];
                leftSum += a[++left];
            }
            if (rightSum != s) {
                // right = A.length - 1 赋予了初值，应该先right--，在rightSum += A[right];
                rightSum += a[--right];
            }
        }
        return false;
    }
}
