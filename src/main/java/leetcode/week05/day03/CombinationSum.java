package leetcode.week05.day03;

import java.util.*;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class CombinationSum {
    /**
     * https://leetcode-cn.com/problems/combination-sum/
     * <p>
     * <p>
     * https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) {
            return res;
        }

        // 排序是为了提前终止搜索
        Arrays.sort(candidates);

        dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private void dfs(int[] candidates,
                     int len,
                     int residue,
                     int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (residue == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {

            //大剪枝
            // 在数组有序的前提下，剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            //小剪枝
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            //元素可以重复使用，递归传递下去的是 i
            dfs(candidates, len, residue - candidates[i], i, path, res);
            // 元素不可以重复使用，递归传递下去的是 i + 1
//            dfs(candidates, len, residue - candidates[i], i+1, path, res);
            path.removeLast();

        }
    }

    /**
     * https://leetcode-cn.com/problems/combination-sum-ii/
     * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) {
            return res;
        }

        // 排序是为了提前终止搜索
        Arrays.sort(candidates);

        dfs2(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private void dfs2(int[] candidates,
                      int len,
                      int residue,
                      int begin,
                      Deque<Integer> path,
                      List<List<Integer>> res) {
        if (residue == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {

            //大剪枝
            // 在数组有序的前提下，剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            //小剪枝
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            //元素可以重复使用，递归传递下去的是 i
            // 元素不可以重复使用，递归传递下去的是 i + 1
            dfs2(candidates, len, residue - candidates[i], i + 1, path, res);
            path.removeLast();

        }
    }

    /**
     * https://leetcode-cn.com/problems/combination-sum-iii/
     * <p>
     * https://leetcode-cn.com/problems/combination-sum-iii/solution/hui-su-jian-zhi-by-liweiwei1419/
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        // 一开始做一些特殊判断
        if (k <= 0 || n <= 0 || k >= n) {
            return res;
        }

        // 寻找 n 的上限：[9, 8, ... , (9 - k + 1)]，它们的和为 (19 - k) * k / 2
        // 比上限还大，就不用搜索了：
        if (n > (19 - k) * k / 2) {
            return res;
        }

        // 根据官方对 Stack 的使用建议，这里将 Deque 对象当做 stack 使用
        // 注意只使用关于栈的接口
        Deque<Integer> path = new ArrayDeque<>();
        dfs3(k, n, 1, path, res);
        return res;
    }

    /**
     * @param k       剩下要找 k 个数
     * @param residue 剩余多少
     * @param start   下一轮搜索的起始元素是多少
     * @param path    深度优先遍历的路径参数（状态变量）
     * @param res     保存结果集的列表
     */
    private void dfs3(int k, int residue, int start, Deque<Integer> path, List<List<Integer>> res) {
        // 剪枝：[start, 9] 这个区间里的数都不够 k 个，不用继续往下搜索
        if (10 - start < k) {
            return;
        }
        if (k == 0) {
            if (residue == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
        }
        for (int i = start; i <= 10 - k; i++) {
            // 剪枝
            if (residue - i < 0) {
                break;
            }
            path.addLast(i);
            dfs3(k - 1, residue - i, i + 1, path, res);
            path.removeLast();
        }
    }

    /**
     *https://leetcode-cn.com/problems/combination-sum-iv/
     *
     *
     * https://leetcode-cn.com/problems/combination-sum-iv/solution/dong-tai-gui-hua-python-dai-ma-by-liweiwei1419/
     * 这里状态定义就是题目要求的，并不难，状态转移方程要动点脑子，也不难：
     * 状态转移方程：dp[i]= dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ... （当 [] 里面的数 >= 0）
     * 特别注意：dp[0] = 1，表示，如果那个硬币的面值刚刚好等于需要凑出的价值，这个就成为 1 种组合方案
     * 再举一个具体的例子：nums=[1, 3, 4], target=7;
     * dp[7] = dp[6] + dp[4] + dp[3]
     * 即：7 的组合数可以由三部分组成，1 和 dp[6]，3 和 dp[4], 4 和dp[3];
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 这个值被其它状态参考，设置为 1 是合理的
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
