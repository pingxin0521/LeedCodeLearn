package leetcode.week08;

//https://pic.leetcode-cn.com/6f41d7e46fd0344c013980e3f46429dd7a7311bb4292783a482466a90f15747b-Picture1.png
public class IsNumber {
    public static void main(String[] args) {
        System.out.println(isNumber("23232"));
    }
    public static boolean isNumber(String s) {
        int len = s.length();
        boolean hasNum = false,hasE = false,hasSign = false,hasDot = false;
        int idx = 0;
        /* 去除前导空格 */
        while (idx<len&&(s.charAt(idx)==' ')){
            idx++;
        }
        /* 从头到尾遍历字符串 */
        while (idx<len){
            /* 如果当前字符c是数字：将hasNum置为true，
             * index往后移动一直到非数字或遍历到末尾位置；
             * 如果已遍历到末尾(index == n)，结束循环
             */
            while (idx<len&&s.charAt(idx)>='0'&&s.charAt(idx)<='9'){
                idx++;
                hasNum = true;
            }
            if (idx==len){
                break;
            }
            char c = s.charAt(idx);
            if(c == 'e' || c == 'E'){
                /* 如果当前字符c是'e'或'E'：
                 * 如果e已经出现或者当前e之前没有出现过数字，返回fasle；
                 * 否则令hasE = true，并且将其他3个flag全部置为false，
                 * 因为要开始遍历e后面的新数字了
                 */
                if(hasE || !hasNum){
                    return false;
                }
                hasE = true;
                hasNum = false; hasSign = false; hasDot = false;
            }else if(c == '+' || c == '-'){
                /* 如果当前字符c是+或-：如果已经出现过+或-
                 * 或者已经出现过数字或者已经出现过'.'，返回flase；
                 * 否则令hasSign = true
                 */
                if(hasSign || hasNum || hasDot){
                    return false;
                }
                hasSign = true;
            }else if(c == '.'){
                /* 如果当前字符c是'.'：
                 * 如果已经出现过'.'或者已经出现过'e'或'E'，返回false；
                 * 否则令hasDot = true
                 */
                if(hasDot || hasE){
                    return false;
                }
                hasDot = true;
            }else if(c == ' '){
                /* 如果当前字符c是' '：
                 * 结束循环，因为可能是末尾的空格了，
                 * 但也有可能是字符串中间的空格，在循环外继续处理
                 */
                break;
            }else{
                /* 如果当前字符c是除了上面5种情况以外的其他字符，直接返回false */
                return false;
            }
            idx++;
        }
        /* 如果当前索引index与字符串长度相等，说明遍历到了末尾，
         * 但是还要满足hasNum为true才可以最终返回true，
         * 因为如果字符串里全是符号没有数字的话是不行的，而且e后面没有数字也是不行的，
         * 但是没有符号是可以的，所以4个flag里只要判断一下hasNum就行；
         * 所以最后返回的是hasNum && index == n
         */
        while (idx<len && s.charAt(idx) == ' '){
            idx++;
        }
        return hasNum && idx == len;
    }
}
