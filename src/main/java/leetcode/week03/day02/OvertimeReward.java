package leetcode.week03.day02;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 加班奖励
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 西西是某公司的一名员工，该公司目前正在做的项目还有N天截止。为鼓励员工加班，在这N天内该公司每天都会为当天加班的员工发放奖金。具体来说，对于当天加班的某位员工，若该员工已经连续加班了i天（1≤i≤N），则其当天能获得的奖金为i（例如 ，第一天加班，则此时记为连续加班1天，获得的奖金为1）。西西制定了这N天内的加班计划，他每天要么加班，要么不加班，要么不确定加不加班（有50%的概率加班，剩下50%的概率不加班），那么西西在这N天内能获得的总奖金的期望是多少？
 * <p>
 * 输入
 * 第一行包含一个整数N，1≤N≤105。
 * <p>
 * 第二行包含N个空格隔开的整数t1到tN，0≤ti≤2。若ti=0，则表示西西在第i天不加班；若ti=1，则表示西西在第i天会加班；若ti=2，则表示西西在第i天有50%的概率加班，剩下50%的概率不加班。
 * <p>
 * 输出
 * 输出总奖金的期望，结果只保留整数部分。
 * <p>
 * <p>
 * 样例输入
 * 3
 * 1 2 1
 * 样例输出
 * 4
 * <p>
 * 提示
 * 西西有50%的概率连续加班3天，总奖金为1+2+3=6，剩下50%的概率只在第1天和第3天加班，总奖金为1+0+1=2，因此总奖金的期望为4。
 * TODO 修正
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week03.day02
 * hyp create at 20-3-27
 **/
public class OvertimeReward {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] data = new int[N];
        List<Integer> l = new ArrayList<>();
        List<Integer> h = new ArrayList<>();
        in.nextLine();
        for (int i = 0; i < N; i++) {
            data[i] = in.nextInt();
            if (data[i] == 0) {
                if (l.size()==0&&h.size()==0)
                {
                    l.add(0);
                }else {
                    l.addAll(h);
                    h.clear();
                }
            } else if (data[i] == 1) {
                if (h.size()==0)
                {
                    h.add(0);
                }
                for (int j = 0; j < l.size(); j++) {
                    l.set(j, l.get(j) + 1);
                }
                for (int j = 0; j < h.size(); j++) {
                    h.set(j, 2 * h.get(j) + 1);
                }
            } else {
                int s=l.size();
                l.addAll(h);
                if (l.size()==0&&h.size()==0)
                {
                    l.add(0);
                }
                if (h.size()==0)
                {
                    h.add(0);
                }
                for (int j = 0; j < h.size(); j++) {
                    h.set(j, 2 * h.get(j) + 1);
                }
                for (int j = 0; j < s; j++) {
                    h.add(l.get(j) + 1);
                }
            }
        }
        long sum=0;
        for (Integer i : l) {
            sum+=i;
        }
        for (Integer i : h) {
            sum+=i;
        }
        System.out.println((int)sum/(l.size()+h.size()));
    }
}
