package test07;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-12
 **/
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
    }
    public static int myAtoi(String str) {
        if (null==str||"".equals(str))
        {
            return 0;
        }
        boolean isMinus = false;
        long ans = 0;
        int i = 0;
        while (i<str.length()&&str.charAt(i) == ' ') {
            i++;
        }
        if (i<str.length()&&(str.charAt(i) == '-' || str.charAt(i) == '+')) {
            if (str.charAt(i) == '-') {
                isMinus = true;
            }
            i++;
        }

        while (i<str.length()&&str.charAt(i) != 0) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                ans = ans * 10 + str.charAt(i) - 48;
                if (ans > 0x7FFFFFFF) {
                    ans = 0x7FFFFFFF;
                    if (isMinus) {
                        ans++;
                    }
                    break;
                }
            } else {
                break;
            }
            i++;
        }
        return (int) (isMinus ? -1 * ans : ans);
    }
}
