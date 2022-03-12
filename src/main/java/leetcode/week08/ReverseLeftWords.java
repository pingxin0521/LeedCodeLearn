package leetcode.week08;

public class ReverseLeftWords {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
    public static String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int N = n % s.length();
        if (N == 0){
            return s;
        }
        for (int i = N; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < N; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseLeftWords2(String s, int n) {
        String left = s.substring(0,n);
        String right = s.substring(n,s.length());
        return right + left;
    }

}
