package leetcode.weeklycontest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *
 *  Created by pingxin on 2021/11/26.
 * </pre>
 *
 * @author pingxin
 * @date 2021/11/26
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMutation("hit", "cog", new String[]{}));

    }

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        char[] gen = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        HashSet<String> visited = new HashSet<>();
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return step;
                }
                StringBuilder sb = new StringBuilder(cur);
                for (int j = 0; j < cur.length(); j++) {
                    char o = sb.charAt(j);
                    for (char c : gen) {
                        if (c == sb.charAt(j)) {
                            continue;
                        }
                        sb.setCharAt(j, c);
                        String s = sb.toString();
                        if (!bankSet.contains(s) && !visited.contains(s)) {
                            queue.offer(s);
                            visited.add(s);
                        }
                    }
                    sb.setCharAt(j,o);
                }
            }
            step++;
        }
        return -1;
    }

}

