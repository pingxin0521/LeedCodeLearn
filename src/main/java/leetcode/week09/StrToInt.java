package leetcode.week09;

/**
 * https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58mttv/
 * 1. 首部空格： 删除
 * 2. 符号位： 三种情况，即 ''+'' , ''−'' , ''无符号" ；新建一个变量保存符号位，返回前判断正负即可；
 * 3. 非数字字符： 遇到首个非字符，返回
 * 4. 数字字符：
     * 1.字符转数字
     * 2.数字拼接
 */
public class StrToInt {
    public int strToInt(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length= str.length();
        if (length==0){
            return 0;
        }
        while (str.charAt(i) ==' '){
            if (++i==length) {
                return 0;
            }
        }
        if (str.charAt(i)=='-'){
            sign=-1;
        }
        if (str.charAt(i)=='-'||str.charAt(i)=='+'){
            i++;
        }
        for (int j = i; j < length; j++) {
            if (str.charAt(j)<'0'||str.charAt(j)>'9') {
                break;
            }
            if (res>bndry||res==bndry&&str.charAt(j)>'7'){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(j)-'0');
        }
        return res * sign;
    }
}
