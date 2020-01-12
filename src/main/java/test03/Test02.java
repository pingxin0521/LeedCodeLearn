package test03;


import java.util.*;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test03
 * hyp create at 19-8-15
 **/
public class Test02 {

    private List<Integer> list;
    private int[][] result;

    /**
     * Initialize your data structure here.
     */
    public Test02() {
        list = new ArrayList<Integer>();
        result = null;
    }

    public void addNum(int val) {
        int i = 0;
        for (; i < list.size(); i++) {
            if (val < list.get(i)) {
                list.add(i, val);
                result = null;
                break;
            } else if (val == list.get(i)) {
                break;
            }

        }
        if (i == list.size()) {
            list.add(val);
            result = null;
        }

    }

    public int[][] getIntervals() {
        if (result == null && list.size() != 0) {
            List<int[]> vo = new ArrayList<int[]>();
            int p = 0, c = 1;
            for (int i = 1; i < list.size(); i++) {
                Integer a = list.get(p);
                Integer b = list.get(i);
                if (a + c == b) {
                    c++;
                } else {
                    vo.add(new int[]{a, a + c});
                    a = i;
                    c = 1;
                }
            }
            result = new int[vo.size()][2];
            int d = 0;
            for (int[] ints : vo) {
                result[d] = ints;
            }
        }
        return result;
    }
}
