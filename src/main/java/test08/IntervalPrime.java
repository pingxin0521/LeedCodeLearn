package test08;

/**
 * 题目：判断101-200之间有多少个素数，并输出所有的素数
 * <p>
 * 素数(prime number)又称质数，有无限个。一个大于1的自然数，除了1和它本身外，不能被其他自然数整除，换句话说就是该数除了1和它本身以外不再有其他的因数;否则称为合数。
 * *也可以这样去判断一个素数：用这个数分别去除2到sqrt（这个数），如果能被整除则不是素数，反之则为素数。这样可以提高效率，以为一个数不可能整除它平方根以后的数了。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-2-27
 **/
public class IntervalPrime {
    private static int primeNum(int m, int n) {
        int count = 0;

        for (int i = m; i < n; i += 2) {
            boolean b = false;
            //sqrt():一个非负实数的平方根函数
            for (int j = 2; j <= Math.sqrt(i); j++) {
                //判断j能否被i整除
                if (i % j == 0) {
                    b = false;
                    break;
                } else {
                    b = true;
                }
            }
            if (b) {
                count++;
                System.out.print(i + "\t");
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("素数的总个数为：" + primeNum(1, 50));
    }
}
