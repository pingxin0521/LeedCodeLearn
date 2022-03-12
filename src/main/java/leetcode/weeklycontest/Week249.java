package leetcode.weeklycontest;

public class Week249 {

    /**
     * https://leetcode-cn.com/contest/weekly-contest-249/problems/concatenation-of-array/
     * @param nums
     * @return
     */
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return new int[]{};
        }
        int[] result = new int[len*2];
        for (int i = 0; i < len; i++){
            result[i] = result[i+len] = nums[i];
        }
        return result;
    }
}
