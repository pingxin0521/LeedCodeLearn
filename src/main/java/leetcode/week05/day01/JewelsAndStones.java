package leetcode.week05.day01;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day01
 * hyp create at 20-6-26
 **/
public class JewelsAndStones {

    /**
     * 遍历每块石头，检查是不是宝石。检查步骤用 哈希集合 来高效完成。
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        Set<Character> Jset = new HashSet();
        for (char j : J.toCharArray())
            Jset.add(j);

        int ans = 0;
        for (char s : S.toCharArray())
            if (Jset.contains(s))
                ans++;
        return ans;
    }
}
