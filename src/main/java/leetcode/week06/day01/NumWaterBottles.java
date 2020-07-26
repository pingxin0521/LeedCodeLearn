package leetcode.week06.day01;

//https://leetcode-cn.com/problems/water-bottles/
public class NumWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) {
            return numBottles;
        }
        int res = numBottles;
        int a = numBottles;
        int b = 0;
        while (a >= numExchange) {
            b = a / numExchange;
            a = a % numExchange + b;
            res += b;
        }
        return res;
    }
}
