package test08;

/**
 * 约瑟夫问题
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-2-25
 **/
public class JosephProblem {
    public static void main(String[] args) {

    }


    public int getResult(int n, int m) {
        // write code here
        //记录人[i]是否淘汰
        boolean[] r = new boolean[n];
        //已淘汰数
        int pass = 0;
        int i = 0;
        int sum = 0;

        while (pass < n) {
            if (i == n) {
                i = 0;
            }
            if (!r[i]) {
                //第i人未淘汰
                sum++;
                if (sum == m) {
                    pass++;
                    r[i] = true;
                    sum = 0;
                    //一人出局
                    continue;
                }
                i++;
            } else {//第i人已淘汰
                i++;
            }

        }
        return i + 1;
    }
}
