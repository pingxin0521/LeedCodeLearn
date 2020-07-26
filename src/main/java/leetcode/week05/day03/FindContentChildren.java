package leetcode.week05.day03;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class FindContentChildren {
    /**
     * 贪心算法
     * 对 需求因子 数组 g 与 糖果大小 数组 s 进行 从小到大 的排序
     * 按照 从小到大 的顺序使用各糖果尝试是否可满足某个孩子,每个糖果 只尝试1次 ;若尝试 成功 ,则换下一个孩子尝试;直到发现没 更多 的孩子或者没 更多 的糖果,循环结束。
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int c=0;
        int e=0;
        while (e<s.length&&c<g.length){
            if (g[c]<=s[e]){
              c++;
            }
            e++;
        }
        return c;
    }
}
