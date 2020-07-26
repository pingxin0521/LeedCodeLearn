package leetcode.week01.day07;

/**
 * https://leetcode-cn.com/problems/rectangle-overlap/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day07
 * hyp create at 20-3-18
 **/
public class IsRectangleOverlap {
    //https://leetcode-cn.com/problems/rectangle-overlap/solution/javayi-xing-dai-ma-da-bai-100yong-hu-fei-chang-jia/
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
    }
}
