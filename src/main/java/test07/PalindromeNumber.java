package test07;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-12
 **/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        String s = String.valueOf(x);

        StringBuilder sb = new StringBuilder(s);
        String r = sb.reverse().toString();
        return s.equals(r);
    }
}
