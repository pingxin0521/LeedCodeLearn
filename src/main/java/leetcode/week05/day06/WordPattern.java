package leetcode.week05.day06;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/word-pattern/
 *
 * 1.设置单词(字符串)到pattern字符的 映射 ( 哈希 ) ;使用数组used[128]记录pattern字符是否使用。
 * 2.遍历str,按照空格 拆分单词 ,同时 对应的 向前移动指向pattern字符的指针,每拆分出一个单词, 判断 :
 * 如果该单词 从未出现 在哈希表中:
 * 如果当前的pattern字符 已被使用 ,则返回false;
 * 将单词与当前指向的pattern字符 做映射 ;
 * 标记 当前指向的pattern字符 已使用 。
 * 否则:
 *  如果当前单词在哈希表中的 映射字符 不是当前指向的pattern字符,则返回false。
 * 3.若单词个数与pattern字符个数 不匹配 ,返回false。
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day06
 * hyp create at 20-6-29
 **/
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<String,Character> map=new HashMap<>();
        boolean[] used=new boolean[26];
        int pos=0;
        String word;
        String[] ss = str.split(" ");
        for (String s:ss){
            if (pos==pattern.length()) {
                return false;
            }
            char c = pattern.charAt(pos);
            if (!map.containsKey(s)){
                if (used[c-'a']){
                    return false;
                }
                map.put(s,c);
                used[c-'a']=true;
            }else {
                if (map.get(s)!=c){
                    return false;
                }
            }
            pos++;
        }
        if (pos!=pattern.length()){
            return false;
        }
        return true;
    }
}
