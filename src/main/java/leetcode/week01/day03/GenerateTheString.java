package leetcode.week01.day03;

/**
 * https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day03
 * hyp create at 20-3-14
 **/
public class GenerateTheString {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder("a");
        if (n%2==0)
        {
            for (int i = 0; i < n - 1; i++) {
                sb.append("b");
            }
        }else {
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
        }
        return sb.toString();
    }
}
