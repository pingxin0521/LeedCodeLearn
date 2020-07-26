package leetcode.week03.day04;

import java.util.TreeMap;

/**
 * https://leetcode-cn.com/contest/weekly-contest-182/problems/count-number-of-teams/
 * TODO 修正
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week03.day04
 * hyp create at 20-3-29
 **/
public class NumTeams {
    public static void main(String[] args) {
        NumTeams teams = new NumTeams();
        System.out.println(teams.numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(teams.numTeams(new int[]{1, 2, 3, 4}));

    }

    public int numTeams(int[] rating) {

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < rating.length; i++) {
            tm.put(rating[i], i);
        }
        Integer[] arr = tm.values().toArray(new Integer[]{});
        for (int i = 0; i < arr.length; i++) {

        }
        System.out.println(tm);

        int res = 0;

        return res;
    }


}
