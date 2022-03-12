package leetcode.week06.day02;

/**
 * https://leetcode-cn.com/problems/count-odd-numbers-in-an-interval-range/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week06.day02
 * hyp create at 20-7-26 下午2:58
 **/
public class CountOdds {
    public int countOdds(int low, int high) {
        if(low>high){
            return 0;
        }
        int c=(high-low)/2;
        if(low%2!=0||high%2!=0){
            c++;
        }
        return c;
    }
}
