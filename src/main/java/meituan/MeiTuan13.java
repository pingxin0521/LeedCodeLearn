package meituan;

/**
 * <pre>
 * https://leetcode-cn.com/problems/0JzXQB/
 *  Created by pingxin on 2022/2/28.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/28
 */

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MeiTuan13 {

    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    /**
     * 把E当成1，F当成-1，求最大子序和即可
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'E') {
                cnt += 1;
                ans = Math.max(cnt, ans);
            } else {
                if (cnt > 0)
                    cnt-- ;
            }
        }
        out.println(ans);
        out.flush();
        out.close();
    }
}
//5
//EFEEF