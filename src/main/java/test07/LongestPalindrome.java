package test07;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-12
 **/
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    public String longestPalindrome3(String s) {
        int n = s.length();
        if(n==1){
            return s;
        }
        int l=0,r=0,len=1;
        int maxStrat=0,maxLen =0;
        for(int i=0;i<n;i++){
            l = i-1;
            r = i+1;
            while(r<n&&s.charAt(r)==s.charAt(i)){
                r++;
                len++;
            }
            i = r -1;
            while(l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                len+=2;
            }
            if(len>maxLen){
                maxLen = len;
                maxStrat =l;
            }
            len = 1;
        }

        return s.substring(maxStrat+1,maxLen + maxStrat +1);
    }
}
