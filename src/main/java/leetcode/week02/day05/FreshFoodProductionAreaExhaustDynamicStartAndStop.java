package leetcode.week02.day05;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 鲜食制作区排风动态启停
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 便利蜂的门店里，有一个鲜食制作的区域。这个区域里，每天早晨、中午、晚上的一些时段，会制作早饭、午饭、晚饭的热餐。
 * <p>
 * 当前，我们开展一个能耗节约的项目，需要动态控制这个鲜食制作区域里的排风装置。控制的策略上，是如下的两个约束条件：
 * <p>
 * 1) 在全部的鲜食制作时间段内、制作时间段前后30分钟，开启排风装置（将制作区域里因制作导致的热空气抽出去）；其他时间段，关闭排风装置。
 * <p>
 * 2) 为了避免排风装置的频繁启停，我们规定排风装置的每一段关闭时间段长度应大于60分钟，否则就不予关闭；即，如果关闭时间不足60分钟，则保持开启状态。
 * <p>
 * 举个例子：
 * <p>
 * 一家门店的制作时间段是：
 * <p>
 * [05:30, 07:30), [10:30, 11:30), [12:30, 13:00), [16:30, 17:30)
 * <p>
 * 按照上述规则，我们的排风装置应该在如下时间段打开，其他时间关闭：
 * <p>
 * [05:00, 08:00), [10:00, 13:30), [16:00, 18:00)
 * <p>
 * 我们精确到分钟，每天按照 1440 分钟来计算，上述的时间段则分别对应了如下的输入、输出：
 * <p>
 * Input:  [330, 450, 630, 690, 750, 780, 990, 1050]
 * <p>
 * Output: [300, 480, 600, 810, 960, 1080]
 * <p>
 * <p>
 * <p>
 * 构造一个算法，完成 Input => Output 的计算过程。
 * <p>
 * 输入
 * 为了简化核心算法编写，你可以假设不会出现错误的 Input 数据。 即，诸如 Input 中元素数量是奇数个、非严格单调递增等错误情况，都不会发生。
 * <p>
 * 请注意边界情况，如 Input 的首末两个数字分别是 0、1439 时（每天的分钟数是 1440），Output 的首末两个数字将是 -30、1469。
 * <p>
 * 输出
 * 输出排风装置应该打开的时间段
 * <p>
 * <p>
 * 样例输入
 * 330,450,630,690,750,780,990,1050
 * 样例输出
 * 300,480,600,810,960,1080
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day05
 * hyp create at 20-3-23
 **/
public class FreshFoodProductionAreaExhaustDynamicStartAndStop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] ss = line.replace("[", "").replace("]", "").split(",");
        int[] data = new int[ss.length];
        int j = 0;
        for (int i = 0; i < ss.length; ) {
            int k = Integer.parseInt(ss[i++].trim()) - 30;
            int l = Integer.parseInt(ss[i++].trim()) + 30;
            if (i == 2 || k > data[j - 1] + 60) {
                data[j++] = k;
                data[j++] = l;
            } else {
                data[j - 1] = k;
                data[j] = l;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(data, j)));
    }
}
