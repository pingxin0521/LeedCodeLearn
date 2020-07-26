package test01;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-3-3
 **/
public class Test04 {

    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7,};
        for (int i : data) {
            tree.add(i);
        }
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        if (k > 0 && k < tree.size()) {
            System.out.println(binaryTreeSearch(tree, k));
        } else {
            System.out.println("-1");
        }
    }

    private static int binaryTreeSearch(TreeSet<Integer> tree, int k) {
        int res = 0;
        for (int i = 0; i < k - 1; i++) {
            tree.pollFirst();
        }

        res = tree.first();
        return res;
    }
}
