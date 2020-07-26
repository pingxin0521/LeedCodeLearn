package leetcode.week01.day04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/happy-number/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day04
 * hyp create at 20-3-15
 **/
public class HappyNum {

    private HashSet<Integer> set = new HashSet<>();

    public boolean isHappy2(int n) {
        if (n == 1) {
            return true;
        }
        set.add(n);
        List<Integer> l = new ArrayList<>();
        while (n > 0) {
            l.add(n % 10);
            n = n / 10;
        }
        n = 0;
        for (int i = 0; i < l.size(); i++) {
            n += l.get(i) * l.get(i);
        }
        if (set.contains(n)) {
            return false;
        }
        return isHappy2(n);
    }

    public boolean isHappy(int n) {
        int p = n, q = getNext(n);
        while (q != 1) {
            p = getNext(p);
            q = getNext(getNext(q));
            if (p == q) {
                return false;
            }
        }
        return true;
    }

    int getNext(int x) {
        int n = 0;
        while (x>0) {
            n += (x % 10) * (x % 10);
            x /= 10;
        }
        return n;
    }

}

