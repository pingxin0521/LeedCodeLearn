package test08;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-3-9
 **/
public class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        if (null != line && !"".equals(line)) {
            char[] chars = line.toCharArray();

            LinkedHashSet<Character> lhs = new LinkedHashSet<>();

            for (char c : chars) {
                if (!lhs.contains(c)) {
                    lhs.add(c);
                }
            }
            lhs.forEach(System.out::print);
        }


        System.out.println();
    }
}
