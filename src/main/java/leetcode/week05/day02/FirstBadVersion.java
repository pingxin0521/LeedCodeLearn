//package leetcode.week05.day02;
//
///**
// * https://leetcode-cn.com/problems/first-bad-version/
// *
// * @author hyp
// * Project name is LeedCodeLearn
// * Include in leetcode.week05.day02
// * hyp create at 20-6-26
// **/
//public class FirstBadVersion {
//    public int firstBadVersion(int n) {
//        int l = 1;
//        int r = n;
//        while (l < r) {
//            int m = l + (r - l) / 2;
//            if (isBadVersion(m)) {
//                r=m;
//            } else {
//                l = m + 1;
//            }
//        }
//        return l;
//    }
//}
