package leetcode.week02.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/cinema-seat-allocation/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day03
 * hyp create at 20-3-21
 **/
public class MaxNumberOfFamilies {

    public static void main(String[] args) {
        MaxNumberOfFamilies number = new MaxNumberOfFamilies();
        System.out.println(number.maxNumberOfFamilies(3, new int[][]{{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}}));
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int ans = 2 * n;
        for (int i = 0; i <= reservedSeats.length - 1; i++) {
            int x = reservedSeats[i][0];
            int y = reservedSeats[i][1];
            if (map.containsKey(x - 1)) map.get(x - 1).add(y - 1);
            else {
                map.put(x - 1, new ArrayList<>());
                map.get(x - 1).add(y - 1);
            }
        }
        //4,5 ：key / vital seats!
        for (Integer i : map.keySet()) {
            List<Integer> list = map.get(i);
            if (list.contains(4) && list.contains(5)) {
                ans -= 2;
                continue;
            }//4，5均被占用，该行无解，ans-=2
            else if (!list.contains(4) && list.contains(5))//5占用，4未占用，该行最多剩余一个解1234，对其特判
            {
                if (!list.contains(4) && !list.contains(3) && !list.contains(2) && !list.contains(1)) ans -= 1;
                else ans -= 2;
            } else if (list.contains(4) && !list.contains(5))//4占用，5未占用，该行最多剩余一个解5678，对其特判
            {
                if (!list.contains(5) && !list.contains(6) && !list.contains(7) && !list.contains(8)) ans -= 1;
                else ans -= 2;
            } else //45均未占用,分别对1234，3456，5678判断是否有解，并对8种可能的情况一一列出
            {
                boolean flag1 = false;
                boolean flag2 = false;
                boolean flag3 = false;
                if (!list.contains(4) && !list.contains(3) && !list.contains(2) && !list.contains(1)) flag1 = true;
                if (!list.contains(3) && !list.contains(4) && !list.contains(5) && !list.contains(6)) flag2 = true;
                if (!list.contains(5) && !list.contains(6) && !list.contains(7) && !list.contains(8)) flag3 = true;
                //flag1:true:可行，false：不可行
                if (flag1 && flag2 && flag3) {
                    continue;
                } else if (flag1 && flag2 && !flag3) {
                    ans -= 1;
                    continue;
                } else if (flag1 && !flag2 && flag3) {
                    continue;
                } else if (flag1 && !flag2 && !flag3) {
                    ans -= 1;
                    continue;
                } else if (!flag1 && flag2 && flag3) {
                    ans -= 1;
                    continue;
                } else if (!flag1 && flag2 && !flag3) {
                    ans -= 1;
                    continue;
                } else if (!flag1 && !flag2 && flag3) {
                    ans -= 1;
                    continue;
                } else if (!flag1 && !flag2 && !flag3) {
                    ans -= 2;
                    continue;
                }
            }
        }
        return ans;
    }
}
