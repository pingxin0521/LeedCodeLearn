package test08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-2-5
 **/
public class CycleWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        List<String> strings=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            strings.add(s);
        }


    }
}
