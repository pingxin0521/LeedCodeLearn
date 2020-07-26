package leetcode.week03.day03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/5045/A
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week03.day03
 * hyp create at 20-3-28
 **/
public class MembraneRecord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        boolean[] res = new boolean[T];
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            in.nextLine();
            Integer[] tmp = new Integer[n];
            for (int j = 0; j < n; j++) {
                String line = in.nextLine();
                for (int k = 0; k < line.length(); k++) {
                    if (tmp[j] == null) {
                        tmp[j] = 0;
                    }
                    if (line.charAt(k) == '*') {

                        tmp[j]++;
                    }
                }
            }
            Arrays.sort(tmp, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            if (a >= n || (a < n && tmp[a] <= b)) {
                res[i] = true;
            }
        }
        for (boolean b : res) {
            if (b) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
