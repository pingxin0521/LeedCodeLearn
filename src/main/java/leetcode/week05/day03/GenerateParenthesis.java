package leetcode.week05.day03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class GenerateParenthesis {
    /**
     * https://leetcode-cn.com/problems/generate-parentheses/
     *
     * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
     *
     * 当前左右括号都有大于 0个可以使用的时候，才产生分支；
     *
     * 产生左分支的时候，只看当前是否还有左括号可以使用；
     *
     * 产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
     *
     * 在左边和右边剩余的括号数都等于 0的时候结算。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }
}
