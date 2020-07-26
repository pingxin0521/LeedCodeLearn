package leetcode.week01.day04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day04
 * hyp create at 20-3-15
 **/
public class ModelFileDeduplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        HashMap<String, TreeSet<String>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] ss = line.split(" ");
            TreeSet<String> set = hm.get(ss[1]);
            if (null == set) {
                TreeSet<String> t = new TreeSet<String>();
                t.add(ss[0]);
                hm.put(ss[1], t);
            } else {
                set.add(ss[0]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, TreeSet<String>> entry : hm.entrySet()) {
            String key = entry.getKey();
            TreeSet<String> value = entry.getValue();
            sb.append(key).append(" ");
            for (String s : value) {
                sb.append(s).append(" ");
            }
            sb.delete(sb.length()-1,sb.length());
            sb.append("\n");
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb.toString());
    }
}

