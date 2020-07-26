package sm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sm
 * hyp create at 20-3-12
 **/
public class Sunday {
    public static void main(String[] args) {

    }


    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int hLen = haystack.length(), nLen = needle.length();
        if (hLen < nLen) {
            return -1;
        }
//        创建偏移表
        Map<Character, Integer> offsetMap = new HashMap<>();
        for (int i = 0; i < nLen; i++) {
            offsetMap.put(needle.charAt(i), nLen - i);
        }
//        开始查找模式串
        int idx = 0;
//        循环直至idx+模式串长度>目标字符串长度
        while (idx + nLen <= hLen) {
//            截取目标字符串
            String cutHay = haystack.substring(idx, idx + nLen);
//            如果子串和模式串相等，则返回idx
            if (cutHay.equals(needle)) {
                return idx;
            } else {
//                边界处理
                if (idx + nLen >= hLen) {
                    return -1;
                }
//                如果子串在目标串中的后一个字符c是否存在于偏移表中
                idx += offsetMap.getOrDefault(haystack.charAt(idx + nLen), nLen);
            }
        }
        return -1;
    }

}
