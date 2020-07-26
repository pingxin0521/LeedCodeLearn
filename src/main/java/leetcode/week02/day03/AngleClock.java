package leetcode.week02.day03;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-19/problems/angle-between-hands-of-a-clock/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day03
 * hyp create at 20-3-21
 **/
public class AngleClock {
    public static void main(String[] args) {
        AngleClock clock = new AngleClock();
        //7.5
        //155.0
        //0.0
        System.out.println(clock.angleClock(3, 15));
        System.out.println(clock.angleClock(4, 50));
        System.out.println(clock.angleClock(12, 0));
    }
    public double angleClock(int hour, int minutes) {
        double ans=Math.abs(5.5*minutes-30*hour);
        if (ans>180){
            ans=360-ans;
        }
        return ans;
    }
}
