package leetcode.week01.day01;

/**
 * 字符串的最大因子
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01
 * hyp create at 20-3-12
 **/
public class GcdOfStrings {
    public static void main(String[] args) {

    }

    /**
     * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/solution/java-hen-jian-ji-yi-yan-jiu-neng-kan-ming-bai-by-s/
     * <p>
     * 1、若s1和s2存在相同的除数X，即s1=XXX, s2=XX, 可见s1+s2=s2+s1
     * 2、现在的问题是：若s1和s2不存在相同的除数，那么是否存在s1+s2=s2+s1的情况呢？
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
