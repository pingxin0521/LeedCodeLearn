package meituan;

import java.io.*;

/**
 * <pre>
 *  https://leetcode-cn.com/problems/SDRaNt/
 *  Created by pingxin on 2022/3/1.
 * </pre>
 *
 * @author pingxin
 * @date 2022/3/1
 */
public class MeiTuan07 {
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));


    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] ans = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = nextInt();
                if (ans[i] == 0 && !used[a - 1]) {
                    ans[i] = a;
                    used[a - 1] = true;
                }
            }
        }
        for (int i : ans) {
            out.print(i);
            out.print(" ");
        }
        out.flush();
        out.close();
    }
}

//5
//1 5 3 4 2
//2 3 5 4 1
//5 4 1 2 3
//1 2 5 4 3
//1 4 5 2 3