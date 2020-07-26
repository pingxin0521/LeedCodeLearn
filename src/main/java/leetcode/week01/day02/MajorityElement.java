package leetcode.week01.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/majority-element/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day02
 * hyp create at 20-3-13
 **/
public class MajorityElement {
    /**
     * 摩尔投票法思路
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     * <p>
     * 为何这行得通呢？
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     * <p>
     * 无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int cardNum = nums[0], count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (cardNum == nums[i]) {
                ++count;
            } else {
                if (--count == 0) {
                    cardNum = nums[i];
                    count = 1;
                }
            }
        }
        return cardNum;
    }

    //https://leetcode-cn.com/problems/majority-element-ii
    //给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
    //多数投票升级版：
    //
    //超过n/3的数最多只能有两个。先选出两个候选人A,B。 遍历数组，分三种情况：
    //
    //1.如果投A（当前元素等于A），则A的票数++;
    //
    //2.如果投B（当前元素等于B），B的票数++；
    //
    //3.如果A,B都不投（即当前与A，B都不相等）,那么检查此时A或B的票数是否减为0：
    //
    //3.1 如果为0,则当前元素成为新的候选人；
    //
    //3.2 如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均减一；
    //遍历结束后选出了两个候选人，但是这两个候选人是否满足>n/3，还需要再遍历一遍数组，找出两个候选人的具体票数。
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        //初始化：定义两个候选人及其对应的票数
        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;
        //遍历数组
        for (int num : nums) {
            if (num == candidateA) {
                countA++;//投A
                continue;
            }
            if (num == candidateB) {
                countB++;//投B
                continue;
            }

            //此时当前值和AB都不等，检查是否有票数减为0的情况，如果为0，则更新候选人
            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }
            //若此时两个候选人的票数都不为0，且当前元素不投AB，那么A,B对应的票数都要--;
            countA--;
            countB--;
        }

        //上一轮遍历找出了两个候选人，但是这两个候选人是否均满足票数大于N/3仍然没法确定，需要重新遍历，确定票数
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == candidateA) {
                countA++;
            } else if (num == candidateB) {
                countB++;
            }
        }
        if (countA > nums.length / 3) {
            res.add(candidateA);
        }
        if (countB > nums.length / 3) {
            res.add(candidateB);
        }
        return res;
    }

}
