package leetcode.week01.day06;

/**
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day06
 * hyp create at 20-3-17
 **/
public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] c = new int[26];
        for(char cc : chars.toCharArray()) {
            c[(int)(cc - 'a')] += 1;
        }
        int res = 0;
        a: for(String word : words) {
            int[] w = new int[26];
            for(char ww : word.toCharArray()) {
                w[(int)(ww - 'a')] += 1;
            }
            for(int i=0; i<26; i++) {
                if(w[i] > c[i]) {
                    continue a;
                }
            }
            res += word.length();
        }
        return res;
    }
}
