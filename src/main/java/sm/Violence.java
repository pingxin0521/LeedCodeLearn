package sm;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sm
 * hyp create at 20-3-12
 **/
public class Violence {
    public static void main(String[] args) {

        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";
        System.out.println(search(p, s));
        System.out.println(s.indexOf(p));
    }

    // 暴力匹配（伪码）
    static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        char[] pArr = pat.toCharArray();
        char[] tArr = txt.toCharArray();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (pArr[j] != tArr[i + j]) {
                    break;
                }
            }
            // pat 全都匹配了
            //匹配成功，返回模式串p在文本串s中的位置，否则返回-1
            if (j == M) {
                return i;
            }
        }
        // txt 中不存在 pat 子串
        return -1;
    }
}
