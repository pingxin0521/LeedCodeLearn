package test08;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-3-9
 **/
public class Hopscotch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        boolean[] res = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] ss = in.nextLine().split(" ");
            res[i] = hopscotch(ss);
        }
        for (boolean b : res) {
            System.out.println(b);
        }
    }

    public static boolean hopscotch(String[] ss) {
        boolean res = false;
        LinkedList<Integer> ll = new LinkedList<>();
        ll.offer(0);
        Integer i = -1;
        while (ll.size() > 0) {
            i = ll.poll();
            if (i>=ss.length)
            {
               break;
            }
            int n = Integer.valueOf(ss[i]);

            Integer j = ll.peekLast()==null?i:ll.peekLast();

            for (int t=i+1;t<=n+i;t++)
            {
                if (t>j)
                {
                    ll.offer(t);
                }
            }
        }
        return i >= ss.length - 1;
    }
}
