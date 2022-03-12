package leetcode.week09;

/**
 * https://leetcode-cn.com/problems/maximum-number-of-removable-characters/
 */
public class MaximumRemovals {
    public int maximumRemovals(String s, String p, int[] removable) {
        int i = 0;
        int j = removable.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            StringBuffer sb = new StringBuffer(s);
            for (int left = 0; left <= m; left++) {
                sb.setCharAt(removable[left], ' ');// 将对应下标处的元素变为空（删除下标处元素）
            }
            if (!isSubsequence(sb.toString(), p)) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return j + 1;
    }

    public int maximumRemovals2(String s, String p, int[] removable) {
        int l = 0;
        int r = removable.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            StringBuffer sb = new StringBuffer(s);
            for (int i = 0; i < m; i++) {
                sb.setCharAt(removable[i], ' ');
            }
            if (!isSubsequence(sb.toString(), p)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r + 1;
    }

    // 判断p是否是s的子串
    public boolean isSubsequence(String s, String p) {
        int m = s.length();
        int n = p.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == n;
    }
}
