package leetcode.week05.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class QueueReconstructionByHeight {
    /**
     * 因为身高高的人不会因为加入身高低的人而改变排序，所以先加入身高高的人。因此，对二维数组进行h降序，k升序排序的处理。这样按顺序加入list中，得到的就是正确的顺序。
     *
     * @param peoplemaxProfit
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {//h相等，k升序
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];//h降序
                }
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][2]);
    }
}
