package leetcode.week05.day03;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/partition-labels/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class PartitionLabels {
    /**
     * 对于遇到的每一个字母，去找这个字母最后一次出现的位置，用来更新当前的最小区间。
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] last = new int[26];//存储每种字符的最后出现位置
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        int i = 0;
        int j = 0;
        for (int k = 0; k < S.length(); k++) {
            //遍历每个字符，更新出现的字符中的最后位置
                    j = Math.max(j, last[S.charAt(k) - 'a']);
            //到达一段的末尾
            if (k == j) {
                list.add(j - i + 1);
                i = j + 1;
            }
        }
        return list;
    }
}
