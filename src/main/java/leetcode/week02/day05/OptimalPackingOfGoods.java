package leetcode.week02.day05;

import java.util.*;

/**
 * 货物最优化装箱
 * <p>
 * 我们有一堆商品，要装到箱子中。已知箱子的容积是3，也知道每个商品的体积。不考虑商品的形状，假设只要N个商品的体积加和，恰好是3，就可以装进箱子。而且，如果商品的体积超过了3，只要恰好是箱子体积的倍数，可以把多个箱子拼成1个大箱子，来装商品。
 * <p>
 * 比如：2个商品，体积加起来是6，可以用2个箱子来装载。
 * <p>
 * 如果加起来是7，就不行了，必须得扔掉某个商品，再继续看能不能装进去。
 * <p>
 * 找出一批商品，恰好装满M个箱子。你能找到的最大的M，是多少？
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day05
 * hyp create at 20-3-23
 **/
public class OptimalPackingOfGoods {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] ss = line.split(",");

        List<Integer> list = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < ss.length; i++) {
            Integer v = Integer.parseInt(ss[i]);
            int t = v % 3;
            if (t == 0) {
                sum += v / 3;
            } else {
                list.add(v);
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        while (list.size() > 0) {
            int k = list.get(0);
            boolean o = false;
            for (int i = 1; i < list.size(); i++) {
                if ((list.get(i) + k) % 3 == 0) {
                    sum += (list.get(i) + k) / 3;
                    list.remove(i);
                    o = true;
                    break;
                }
            }

            list.remove(0);
        }

        System.out.println(sum);

    }
}
