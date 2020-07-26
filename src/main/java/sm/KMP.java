package sm;

/**
 * KMP分为两部分，next 数组 和 正式匹配
 * <p>
 * next 数组 部分：开一个数组next，找每个字符前的 最大相等前后缀长度，我简单地通过举例解释一下这个词：
 * <p>
 * 比如 aba --> 一个前缀是 a，一个后缀是 a，最大相等前后缀长度 为 1
 * 比如 baba --> 一个前缀是 ba，一个后缀是 ba，最大相等前后缀长度 为 2
 * 比如 ababa --> 一个前缀是 aba，一个后缀是 aba，最大相等前后缀长度 为 3，为什么不是前缀 ababa，后缀 ababa 呢，是因为前缀不包含最后一个字符，后缀不包含第一个字符。为什么不是前缀 a 后缀 a 呢，因为尽管它们是一对相等前后缀，但它们不是 最大 相等前后缀长度
 * <p>
 * 设置i j指针，i j最初位于开头和索引为 1 的位置，分别代表前缀，后缀指针，前缀后缀串有个特点：前缀串总是从0开始，而后缀串总是相对于前缀串(不能确定开始的位置)，因此每当 i j 失配时，i 就回溯到上一个位置，那 i 怎么回到上一个位置，这个地方是最难理解的：next[i] 就是 i 应该回到的位置（ps:如果你是为了考试但还不能理解，建议背下来，可以不用花时间去理解了，始终记住一回溯就是 i = next[i]，如果放一堆证明公式在这里，相信肯定令人昏昏欲睡！）然后进行下一轮匹配，直到 j 走完了，next数组才算完成
 * <p>
 * 正式匹配 部分：现在来讨论主串与模式串的关系了，主串就是被匹配的串，模式串是要拿去匹配的其他字符串的字符串(有点拗口)，通常模式串长度小于主串。用 i j 作为主串 模式串的指针，这时模式串是相对的，主串是绝对的，因为主串匹配不上就得往后走，而模式串匹配不上就得再重新匹配前面一部分，因此每当 i j 失配时，j 就回溯到上一个位置(这里的回溯同理)，进行下一轮匹配，直到 j 走完了，说明匹配成功，返回 i - j，因为i - j 对应的就是匹配到的起始位置。若匹配不上的话，i 就走到结尾了，返回 -1
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sm
 * hyp create at 20-3-12
 **/
public class KMP {

    public static void main(String[] args) {

        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";
        System.out.println(strStr(s, p));
    }

    public static int[] cal_next(String str) {                // 计算关于 模式串 的 next 数组
        int len = str.length();
        int[] next = new int[len];
        next[0] = -1;
        int i = 0, j = 1;                                    // i j 分别是前后缀指针
        while (j < len) {
            if (i == -1 || str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                if (j < len) {
                    next[j] = i;
                }
            } else {
                i = next[i];
            }
        }
        return next;
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        int[] next = cal_next(needle);                        // 计算 needle 的前后缀
        int i = 0, j = 0, len = haystack.length(), subLen = needle.length();
        while (i < len) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == subLen) {
                    return i - j;                // needle 指针走到末尾，说明匹配成功
                }
            } else {
                j = next[j];
            }
        }
        return -1;
    }
}
