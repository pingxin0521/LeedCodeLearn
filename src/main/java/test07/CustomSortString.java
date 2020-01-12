package test07;

/**
 * https://leetcode-cn.com/problems/custom-sort-string/
 * <p>
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 * <p>
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 * <p>
 * 返回任意一种符合条件的字符串T。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-12
 **/
public class CustomSortString {
    /**
     * 核心： 桶排序之计数排序，将符合条件的放入桶中，并计数，取出时有序
     * 其余字符找个字符数组存起来即可
     */
    public String customSortString(String S, String T) {
        int[] flag = new int[26];
        char[] other = new char[200];
        int otherSize = 0;
        for (int i = 0; i < T.length(); i++) {
            if (S.indexOf(T.charAt(i)) == -1) {
                other[otherSize++] = T.charAt(i);
            } else {
                flag[T.charAt(i) - 'a']++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < flag[S.charAt(i) - 'a']; j++) {
                sb.append(S.charAt(i));
            }
        }
        for (int i = 0; i < otherSize; i++) {
            sb.append(other[i]);
        }
        return sb.toString();
    }
}
