//package leetcode.week05.day01;
//
///**
// * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
// * @author hyp
// * Project name is LeedCodeLearn
// * Include in leetcode.week05.day01
// * hyp create at 20-6-26
// **/
//public class GuessTheNumberSize {
//    public int guessNumber(int n) {
//        int low = 1;
//        int high = n;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            int res = guess(mid);
//            if (res == 0)
//                return mid;
//            else if (res < 0)
//                high = mid - 1;
//            else
//                low = mid + 1;
//        }
//        return -1;
//    }
//}
