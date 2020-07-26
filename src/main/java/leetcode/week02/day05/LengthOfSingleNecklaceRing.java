package leetcode.week02.day05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 单项链表环的长度
 * <p>
 * 题目描述：
 * 检查单向链表是否存在环，若存在环则返回环的长度，否则返回0。
 * <p>
 * 要求：算法实现尽可能做到时间、空间复杂度最优。
 * <p>
 * 输入
 * [ [ 1, 2 ], [ 2, 3 ] ]，表示的就是一个单向链表，1->2->3
 * <p>
 * 输出
 * 环的长度
 * <p>
 * <p>
 * 样例输入
 * [[1,2],[2,3],[3,4],[4,5],[5,3]]
 * 样例输出
 * 3
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day05
 * hyp create at 20-3-23
 **/
public class LengthOfSingleNecklaceRing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Map<Integer, Integer> map = new HashMap<>();
        String[] ss = line.replace("[", "").replace("]", "").split(",");

        int len = 0;
        boolean is = false;
        int tk = -1;
        int tv = -1;

        for (int i = 0; i < ss.length; i++) {
            int k = Integer.parseInt(ss[i++]);
            int v = Integer.parseInt(ss[i]);
            if (map.containsKey(v)) {
                tk = k;
                tv = v;
                is = true;
            } else {
                map.put(k, v);
            }
        }

        if (is) {
            int i = tv;
            int j = -1;
            while ((j = map.get(i)) != tk) {
                len++;
                i = j;
            }
            len += 2;
        }

        System.out.println(len);
    }
}
