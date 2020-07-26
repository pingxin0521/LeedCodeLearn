package leetcode.week02.day03;

/**
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day03
 * hyp create at 20-3-21
 **/
public class CanMeasureWater {
    //预备知识：贝祖定理
    // https://baike.baidu.com/item/%E8%A3%B4%E8%9C%80%E5%AE%9A%E7%90%86/5186593?fromtitle=%E8%B4%9D%E7%A5%96%E5%AE%9A%E7%90%86&fromid=5185441
    //
    //我们认为，每次操作只会让桶里的水总量增加 x，增加 y，减少 x，或者减少 y。
    //
    //你可能认为这有问题：如果往一个不满的桶里放水，或者把它排空呢？那变化量不就不是 x 或者 y 了吗？接下来我们来解释这一点：
    //
    //首先要清楚，在题目所给的操作下，两个桶不可能同时有水且不满。因为观察所有题目中的操作，操作的结果都至少有一个桶是空的或者满的；
    //
    //其次，对一个不满的桶加水是没有意义的。因为如果另一个桶是空的，那么这个操作的结果等价于直接从初始状态给这个桶加满水；而如果另一个桶是满的，那么这个操作的结果等价于从初始状态分别给两个桶加满；
    //
    //再次，把一个不满的桶里面的水倒掉是没有意义的。因为如果另一个桶是空的，那么这个操作的结果等价于回到初始状态；而如果另一个桶是满的，那么这个操作的结果等价于从初始状态直接给另一个桶倒满。
    //
    //因此，我们可以认为每次操作只会给水的总量带来 x 或者 y 的变化量。因此我们的目标可以改写成：找到一对整数 a, ba,b，使得
    //
    //ax+by=z
    //ax+by=z
    //
    //而只要满足 z\leq x+yz≤x+y，且这样的 a, ba,b 存在，那么我们的目标就是可以达成的。这是因为：
    //
    //若 a\geq 0, b\geq 0a≥0,b≥0，那么显然可以达成目标。
    //
    //若 a\lt 0a<0，那么可以进行以下操作：
    //
    //往 y 壶倒水；
    //
    //把 y 壶的水倒入 x 壶；
    //
    //如果 y 壶不为空，那么 x 壶肯定是满的，把 x 壶倒空，然后再把 y 壶的水倒入 x 壶。
    //
    //重复以上操作直至某一步时 x 壶进行了 aa 次倒空操作，y 壶进行了 bb 次倒水操作。
    //
    //若 b\lt 0b<0，方法同上，x 与 y 互换。
    //
    //而贝祖定理告诉我们，ax+by=zax+by=z 有解当且仅当 zz 是 x, yx,y 的最大公约数的倍数。因此我们只需要找到 x, yx,y 的最大公约数并判断 zz 是否是它的倍数即可。
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int max = a > b ? a : b;
        int min = a > b ? b : a;
        // 第一步：如果两个数是偶数，则先用2进行约分，并存储约去的2的乘积
        int product = 1;
        while (min % 2 == 0 && max % 2 == 0) {
            min /= 2;
            max /= 2;
            product *= 2;
        }

        // 第二步：用较大的数减去较小的数，接着把所得的差与较小的数比较，并以大数减小数
        // 继续这个操作，直到所得的减数和差相等为止。（或者多循环一次，判断相减差为 0）
        while (max - min > 0) {
            int deference = max - min; // 获得差数
            // 更相减损，将差数和较小数比较；大的重新赋给 max，小的赋给min，注意顺序
            max = min > deference ? min : deference;
            min = min < deference ? min : deference;
        } // while

        // 实际上，第一步约去的2的乘积，就是num1和num2的约数
        // 第二步最后算出的差或者较小数，就是第二步刚开始的两个数的最大公约数
        // 第一步的结果乘上第二步的结果，就是 num1 和 num2 的最大公约数
        return product * min;
    }

}
