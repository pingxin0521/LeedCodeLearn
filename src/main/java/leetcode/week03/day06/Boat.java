package leetcode.week03.day06;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 坐船问题
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week03.day06
 * hyp create at 20-4-14
 **/
public class Boat {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strings = s.split(" ");
        int[] w = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            w[i] = Integer.parseInt(strings[i]);
        }
        int maxLoad = in.nextInt();
        int count = countLeastBoat(w, maxLoad);
        System.out.println(count);

    }

    private static int countLeastBoat(int[] w, int maxLoad) {
        Arrays.sort(w);
        int sum = 0;
        int j = w.length - 1, i = 0;
        while (i <= j) {
            if (w[j] + w[i] <= maxLoad) {
                i++;
                j--;
                sum++;
            } else if (w[j] <= maxLoad) {
                j--;
                sum++;
            } else {
                j--;
            }
        }
        return sum;
    }
}
