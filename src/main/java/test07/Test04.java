package test07;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-9
 **/
public class Test04 {


    public static void main(String[] args) {
        //集合：0,1,2,3,4,5,6,7,8,9
        //时间格式:hh:mm:ss.www
        //hh:0-23:
        //mm:0-59
        //ss:0-59
        //www:0-999
        //
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Test04 test04 = new Test04();

//        System.out.println(Arrays.toString(test04.getNoZeroIntegers(11)));

        System.out.println(test04.minFlips(2, 6, 5));
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        init(n);
        for (int[] con : connections) {
            unite(con[0], con[1]);
        }

        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (findfa(i) == i) {
                ++cnt;
            }
        }
        return cnt - 1;
    }

    int ra[] = new int[100100];
    int fa[] = new int[100100];


    void init(int n) {
        for (int i = 0; i < n; ++i) {
            fa[i] = i;
            ra[i] = 0;
        }
    }

    int findfa(int x) {
        if (fa[x] == x) {
            return x;
        }
        return fa[x] = findfa(fa[x]);
    }

    void unite(int x, int y) {
        x = findfa(x);
        y = findfa(y);
        if (x == y) {
            return;
        }
        if (ra[x] < ra[y]) {
            fa[x] = y;
        } else {
            fa[y] = x;
            if (ra[x] == ra[y]) {
                ++ra[x];
            }
        }
    }


    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            if ((c & (1 << i)) != 0) {
                if ((a & (1 << i)) == 0 &&
                        (b & (1 << i)) == 0) {
                    ++ans;
                }
            } else {
                if ((a & (1 << i)) != 0) {
                    ++ans;
                }
                if ((b & (1 << i)) != 0) {
                    ++ans;
                }
            }
        }
        return ans;
    }


    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (check(i) && check(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[]{};
    }

    boolean check(int x) {
        while (x > 0) {
            if (x % 10 == 0)
                return false;
            x /= 10;
        }
        return true;
    }

}
