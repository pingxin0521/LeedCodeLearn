package leetcode.week04.day07;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * <p>
 * 1. Set
 * 2. 双指针:先将nums1 与nums2 排序，然后游走两个指针
 * 3. 二分查找:将nums2排序，然后查找nums1的元素，需要准备一个binarySearch的辅助方法，注意left <= right
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day07
 * hyp create at 20-6-25
 **/
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int target : nums1) {
            if (binarySearch(nums2, target) && !set.contains(target)) {
                set.add(target);
            }
        }
        int index = 0;
        int[] res = new int[set.size()];
        for (int num : set) {
            res[index++] = num;
        }
        return res;
    }

    public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }

    //https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/



    //优化
    //如果给定的数组已经排好序呢？你将如何优化你的算法？
    //如果 nums1 的大小比 nums2 小很多，哪种方法更优？
    //如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？通过归并外排将两个数组排序后再使用排序双指针查找

    /**
     * 将两个数组进行排序，随后用双指针顺序查找相同的元素
     * 时间复杂度O(max(nlogn, mlogm, n+m))，空间复杂度O(1) (n,m分别为两个数组的长度)
     *
     * 如果是进阶问题一中已排序的数组，则只需O(n)的时间复杂度
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        //假设已排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list=new ArrayList<>();
        int r=0,l=0;
        while (l<nums1.length&&r<nums2.length){
            if (nums1[l]<nums2[r]){
                l++;
            }else if (nums1[l]>nums2[r]){
                r++;
            }else {
                list.add(nums1[l]);
                l++;
                r++;
            }
        }
        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    /**
     * 将较小的数组哈希计数，随后在另一个数组中根据哈希来寻找。
     * 时间复杂度O(max(n, m)) 空间复杂度O(min(n, m))
     *
     * 适用于进阶问题二
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        //数字--出现次数
        Map<Integer,Integer> map=new HashMap<>();
        for (int i : nums1) {
            if(map.containsKey(i)){
                Integer t = map.get(i);
                t++;
                map.put(i,t);
            }
            map.put(i,1);
        }
        List<Integer> list=new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)){
                Integer t = map.get(i);
                t--;
                if (t==0){
                    map.remove(i);
                }
                list.add(i);
            }
        }
        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(intersection.intersection1(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
