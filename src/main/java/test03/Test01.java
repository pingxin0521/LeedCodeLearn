package test03;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 不妨假设 nums1 的长度小于 nums2 的长度。记 m = nums1.size(), n = nums2.size().
 * <p>
 * 假设有游标 r，在 nums1[0..m) 中间滑动。游标 r 把 num1 分割成了两半，分别是 nums1[0..r), num1[r..m)
 * <p>
 * 根据中位数的性质，在一个数组中，中位数左侧元素的数量刚好为总元素数量的一半（或一半减 1 个）。
 * <p>
 * 根据此性质，我们在 nums2 中计算一个游标 s, s = (m+n)/2 - r，这
 * 样算出来的 s 把 nums2 分割成了两半，分别是 nums2[0..s), nums2[s..n)。
 * <p>
 * 通过 r 计算出的 s。注意了，nums1 的左侧部分的数量 + nums2 左侧部分的元素数量，刚好为 (m+n)/2 = (3+4)/2 = 3 个（左侧是 a1, b1, b2 这 3 个元素）。
 * 假设在这种情况下，a1 <= b3 且 b2 <= a2，说明找到了分割点。那么中位数就是游标 r 和游标 s 中的较小者（因为在上面这个例子中，总和是奇数个。）
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test03
 * hyp create at 19-8-14
 **/
public class Test01 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{2, 3, 5}, new int[]{7, 26, 8}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int lo = 0, hi = m;

        int p, q, r, s;

        // mid1 总指向后一半的第一个元素。
        // [a1, a2, a3]
        //   ^   ^
        //   p   r = mid1 = 2
        // [b1, b2, b3, b4]
        //       ^   ^
        //       q   s = mid2 = s = 4 - 1 = 2;
        while (lo < hi) {
            int mid1 = lo + (hi - lo) / 2; // mid1 个元素
            int mid2 = total / 2 - mid1; // mid2 个元素

            q = mid2 - 1;
            r = mid1;

            if (q >= 0 && q < n && nums2[q] > nums1[r]) {
                lo = mid1 + 1;
            } else {
                hi = mid1;
            }
        }

        r = hi;
        s = total / 2 - r;
        p = r - 1;
        q = s - 1;

        int left = Math.max((p >= 0 && p < m) ? nums1[p] : Integer.MIN_VALUE, (q >= 0 && q < n) ? nums2[q] : Integer.MIN_VALUE);
        int right = Math.min((r >= 0 && r < m) ? nums1[r] : Integer.MAX_VALUE, (s >= 0 && s < n) ? nums2[s] : Integer.MAX_VALUE);

        if (total % 2 == 1) {
            return right;
        } else {
            return (left + right) / 2.0;
        }

    }
}
