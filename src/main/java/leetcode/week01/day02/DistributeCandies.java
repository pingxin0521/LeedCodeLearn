package leetcode.week01.day02;

import java.util.Arrays;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day02
 * hyp create at 20-3-13
 **/
public class DistributeCandies {
    /**
     * https://leetcode-cn.com/problems/distribute-candies/
     *
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++)
            if (candies[i] > candies[i - 1])
                count++;
        return count;
    }

    public int[] distributeCandies(int candies, int num_people) {
        int i = 0;
        int[] res = new int[num_people];
        while (candies > 0) {
            res[i % num_people] += (candies - i - 1 >= 0 ? i + 1 : candies);
            candies -= (i + 1);
            ++i;
        }
        return res;
    }
}
