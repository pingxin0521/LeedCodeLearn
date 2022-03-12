package meituan;

import java.io.*;
import java.util.Stack;

/**
 * <pre>
 * https://leetcode-cn.com/problems/z3XKBp/
 *  Created by pingxin on 2022/3/1.
 * </pre>
 *
 * @author pingxin
 * @date 2022/3/1
 */
public class MeiTuan06 {

    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));


    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        String s = sc.readLine();

        Stack<Character> lComp = new Stack<Character>();
        lComp.push('T');
        lComp.push('M');

        Stack<Character> rComp = new Stack<Character>();
        rComp.push('M');
        rComp.push('T');
        int l = 0;
        int r = n - 1;
        while (!lComp.isEmpty() && l <= r) {
            if (s.charAt(l) == lComp.peek()) {
                lComp.pop();
            }
            l++;
        }
        while (!rComp.isEmpty() && l <= r) {
            if (rComp.peek() == s.charAt(r)) {
                rComp.pop();
            }
            r--;
        }
        out.println(s.substring(l, r + 1));

        out.flush();
        out.close();
    }
}

