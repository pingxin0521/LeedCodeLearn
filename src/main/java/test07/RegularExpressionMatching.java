package test07;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-12
 **/
public class RegularExpressionMatching {
    //    public boolean isMatch(String s, String p) {
//        return s.matches(p);
//    }
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int sIndex = 0, pIndex = 0;
        return matchCore(s, sIndex, p, pIndex);
    }

    public boolean matchCore(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;//匹配到结尾了，匹配成功
        }
        if (sIndex < s.length() && pIndex == p.length()) {
            return false;//p先结束，匹配失败
        }
        //模式的第2个是*,分两种情况：第一个能/不能匹配上
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            //第一个匹配上了（字符相同或者和‘.’匹配），分三种情况
            //① sIndex+1：继续用*匹配下一个 ② sIndex+1,pIndex+2：结束*匹配，判断下一个字符 ③pIndex+2：当*前面的字符没有出现过
            if ((sIndex < s.length() && p.charAt(pIndex) == s.charAt(sIndex)) || (sIndex < s.length() && p.charAt(pIndex) == '.')) {
                return matchCore(s, sIndex + 1, p, pIndex) || matchCore(s, sIndex + 1, p, pIndex + 2) || matchCore(s, sIndex, p, pIndex + 2);
            } else {//第一个匹配不上，认为其没出现过，判断下面的
                return matchCore(s, sIndex, p, pIndex + 2);
            }
        } else {//模式的第二个不是*，匹配上就下一个，匹配不上就结束
            if ((sIndex < s.length() && p.charAt(pIndex) == s.charAt(sIndex)) || (sIndex < s.length() && p.charAt(pIndex) == '.')) {
                return matchCore(s, sIndex + 1, p, pIndex + 1);
            } else {
                return false;
            }
        }
    }

}
