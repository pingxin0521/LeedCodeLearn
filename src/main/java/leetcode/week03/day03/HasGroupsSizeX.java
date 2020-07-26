package leetcode.week03.day03;

/**
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week03.day03
 * hyp create at 20-3-28
 **/
public class HasGroupsSizeX {
    //https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/solution/qiu-jie-zui-da-gong-yue-shu-java-by-liweiwei1419/
    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        if (len < 2) {
            return false;
        }

        // 计数数组，10000 是根据题目给出的数值范围定的
        int[] cnt = new int[10000];
        for (int num : deck) {
            cnt[num]++;
        }
        // 先得到第 1 个数的个数，以避免在循环中赋值
        int x = cnt[deck[0]];
        for (int i = 0; i < 10000; i++) {
            if (cnt[i] == 1) {
                return false;
            }
            if (cnt[i] > 1) {
                x = gcd(x, cnt[i]);
            }
            if (x == 1) {
                return false;
            }
        }
        return true;

    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        HasGroupsSizeX solution = new HasGroupsSizeX();
        // int[] deck = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        // int[] deck = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
        // int[] deck = new int[]{1};
        // int[] deck = new int[]{1, 1};
        int[] deck = new int[]{0, 0, 1, 1, 1, 1, 2, 2, 3, 4};
        // boolean res = solution.hasGroupsSizeX(deck);
        // System.out.println(res);
        System.out.println(solution.gcd(2, 8));
    }

}
