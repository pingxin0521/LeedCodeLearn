package leetcode.week08;

import leetcode.week04.day01.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

public class XorQueriesSolution {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,4,8};
        int[][] queries1 = new int[][]{{0,1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(xorQueries2(arr1, queries1)));

        int[] arr2 = new int[]{4, 8, 2, 10};
        int[][] queries2 = new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}};
        System.out.println(Arrays.toString(xorQueries2(arr2, queries2)));


    }

    /**
     * 1. tmpArr[n] = arr[0]^...^arr[n]
     * 2. x ^ y ^ x = y
     * tmpArr[m-1] = arr[0]^...^arr[m-1]
     * tmpArr[n] = arr[0]^...^arr[n]
     * 则：arr[m]^...^arr[n] = (arr[0]^...^arr[n])^(arr[0]^...^arr[m-1]) = tmpArr[n] ^ tmpArr[m-1]
     * 3. 故： arr[m]^...^arr[n]= tmpArr[n] ^ tmpArr[m-1]
     *
     * @param arr
     * @param queries
     * @return
     */
    public static int[] xorQueries(int[] arr, int[][] queries) {
        if (arr.length == 0 || queries.length == 0) {
            return new int[]{};
        }
        int[] tmpArr = new int[arr.length];
        tmpArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tmpArr[i] = arr[i] ^ tmpArr[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int m = queries[i][0];
            int n = queries[i][1];
            // 不需要操作
            if (m == n) {
                res[i] = arr[m];
                //等于tmp中的值
            } else if (m == 0) {
                res[i] = tmpArr[n];
            } else {
                int a = tmpArr[m - 1];
                int b = tmpArr[n];
                res[i] = b ^ a;
            }
        }
        return res;
    }

    public static int[] xorQueries2(int[] arr, int[][] queries) {
        if (arr.length == 0 || queries.length == 0) {
            return new int[]{};
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] ^ arr[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int m = queries[i][0];
            int n = queries[i][1];
            if (m == 0) {
                res[i] = arr[n];
            } else {
                int a = arr[m - 1];
                int b = arr[n];
                res[i] = b ^ a;
            }
        }
        return res;
    }
}
