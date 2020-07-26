package leetcode.week05.day01;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * <p>
 * <p>
 * 时间复杂度是O(nklog^k)，其中n是字符串数组的长度，k是其中最长的一个字符串的长度。
 * 1、首先声明一个map，key为排序后的词，因为anagram排序后都一样，所以可以借此分出不同的组。
 * 2、value设为string类型的list，它每遇到自己key下的字符串时，就把它拉进list中
 * 3、最后再遍历一遍list，输出给结果就可以了。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day01
 * hyp create at 20-6-26
 **/
public class LetterEccentricGrouping {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        //O(n), n = the length of strs
        for (int i = 0; i < strs.length; i++) {

            String s = strs[i];
            char[] c = s.toCharArray();
            //O(k*log^k), k = the longest string in strs
            Arrays.sort(c);
            s = new String(c);
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(strs[i]);
                map.put(s, list);
            } else {
                List<String> list = new LinkedList<>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }
        //O(m), m = the number of anagram group
        for (List list : map.values())
            res.add(list);

        return res;
    }
}
