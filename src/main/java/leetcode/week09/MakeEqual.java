package leetcode.week09;

/**
 * https://leetcode-cn.com/problems/redistribute-characters-to-make-all-strings-equal/
 */
public class MakeEqual {
    public static void main(String[] args) {
        String[] strings = {"az", "a"};
        boolean b = makeEqual(strings);
        System.out.println(b);
    }
    public static boolean makeEqual(String[] words) {
        int[] a = new int[26];
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                a[word.charAt(i)-'a']++;
            }
        }
        int length = words.length;
        for (int i : a) {
            if (i%length!=0){
                return false;
            }
        }
        return true;
    }
}
