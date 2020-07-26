package leetcode.week02.day03;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day03
 * hyp create at 20-3-21
 **/
public class FindTheDistanceValue {
    public static void main(String[] args) {
        FindTheDistanceValue distanceValue = new FindTheDistanceValue();
        System.out.println(distanceValue.findTheDistanceValue(new int[]{1, 4, 2, 3}
                , new int[]{-4, -3, 6, 10, 20, 30}
                , 3));
        System.out.println(distanceValue.findTheDistanceValue(new int[]{2,1,100,3}
                , new int[]{-5,-2,10,-3,7}
                , 6));
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        if (null == arr1 || arr1.length == 0) {
            return res;
        }
        for (int i : arr1) {
            boolean is = true;
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    is = false;
                    break;
                }
            }
            if (is) {
                res++;
            }
        }
        return res;
    }
}
