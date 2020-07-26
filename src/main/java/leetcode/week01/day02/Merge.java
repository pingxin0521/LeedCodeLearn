package leetcode.week01.day02;

/**
 * https://leetcode-cn.com/problems/sorted-merge-lcci/
 *
 * 需要比较 m + nm+n 个数的大小，所以先保证其中至少 mm 或 nn 个数比较完毕并放在正确位置，再考虑剩下的数。
 * 注意 mm 和 nn 是未遍历的、有效的数字的个数，不是下标，作为下标要 -1−1 。写的时候偷懒，可能有些地方可读性比较差。
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day02
 * hyp create at 20-3-13
 **/
public class Merge {
    public void merge(int[] A, int m, int[] B, int n) {
        // 先确保将其中一个数组中的数字遍历完
        while (m > 0 && n > 0) {
            // 对比选出较大的数放在 m + n - 1 的位置，并将选出此数的指针向前移动
            A[m + n - 1] = A[m - 1] > B[n - 1] ? A[m-- - 1] : B[n-- - 1];
        }
        // 剩下的数都比已经遍历过的数小
        // 如果 m 不为 0，则 A 没遍历完，都已经在 A 中不用再管
        // 如果 n 不为 0，则 B 没遍历完，直接全移到 A 中相同的位置
        while (n > 0) {
            A[n - 1] = B[n - 1];
            n--;
        }

    }

    // 测试一下
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        new Merge().merge(A, 3, B, 3);
        for (int i1 : A) {
            System.out.print(i1 + ",");
        }
    }

}
