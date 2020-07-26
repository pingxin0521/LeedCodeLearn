package leetcode.week01.day04;

import java.util.BitSet;

/**
 * https://leetcode-cn.com/problems/count-primes
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day04
 * hyp create at 20-3-15
 **/
public class CountPrimes {
    //https://leetcode-cn.com/problems/count-primes/solution/ru-he-gao-xiao-pan-ding-shai-xuan-su-shu-by-labula/
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        BitSet bit = new BitSet(n);
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!bit.get(i)) {
                for (int j = i * i; j < n; j += i) {
                    bit.set(j);
                }
            }
        }
        return n - 2 - bit.cardinality();//排除n和1
    }

}
