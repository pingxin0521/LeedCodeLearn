package test07;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-6
 **/
public class Test03 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        String[] A = null, B = null;


        String _s;
        try {
            _s = in.nextLine();
            A = _s.split(" ");
        } catch (Exception e) {
            _s = null;
        }

        try {
            _s = in.nextLine();
            B = _s.split(" ");
        } catch (Exception e) {
            _s = null;
        }

        int i = in.nextInt();

        String t = String.valueOf(i);

        int num = 0;

        Stack<String> stack = new Stack<String>();

        for (String s : A) {
            if (s.equals(t)) {
                stack.push(t);
                break;
            }
        }

        while (!stack.empty()) {
            String s = stack.pop();
            num++;
            for (int j = 0; j < B.length; j++) {
                if (B[j].equals(s)) {
                    stack.push(A[j]);
                }
            }
        }

        System.out.println(num);

    }
}
