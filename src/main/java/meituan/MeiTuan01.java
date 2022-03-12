package meituan;

/**
 * <pre>
 *
 * https://leetcode-cn.com/problems/BaR9fy/
 *  Created by pingxin on 2022/2/28.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/28
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class MeiTuan01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLine();
        }
        boolean[] ans = new boolean[n];
        for (int i = 0; i < n; i++) {
            ans[i] = check(arr[i]);
        }
        for (boolean i : ans) {
            System.out.println(i ? "Accept" : "Wrong");
        }
    }

    private static boolean check(String userName) {
        String startWithLetter = "^[A-Za-z]";
        String lettersAndDigits = "[^A-Za-z0-9]";
        String leastOneLetterOrNum = "[\\d]";
        boolean safe = true;
        safe &= Pattern.compile(startWithLetter).matcher(userName).find();
        safe &= !Pattern.compile(lettersAndDigits).matcher(userName).find();
        safe &= Pattern.compile(leastOneLetterOrNum).matcher(userName).find();
        return safe;
    }
}
