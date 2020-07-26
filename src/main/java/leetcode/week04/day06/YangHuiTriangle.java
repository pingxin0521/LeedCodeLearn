package leetcode.week04.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day06
 * hyp create at 20-6-24
 **/
public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        //存储要返回的杨辉三角
        List<List<Integer>> dp = new ArrayList<>();
        //若0行，则返回空
        if (numRows == 0) {
            return dp;
        }
        dp.add(new ArrayList<>());
        dp.get(0).add(1);
        //注意这里的 i 是指行数，但是dp是从0开始的
        //所以preRow是i-2
        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = dp.get(i - 2);
            row.add(1);
            for (int j = 1; j < i - 1; j++) {
                row.add(preRow.get(j) + preRow.get(j - 1));
            }
            row.add(1);
            dp.add(row);
        }
        return dp;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int N = rowIndex;
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= N; k++) {
            long cur = pre * (N - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new YangHuiTriangle().generate(5));
        System.out.println(new YangHuiTriangle().getRow(5));

    }
}
