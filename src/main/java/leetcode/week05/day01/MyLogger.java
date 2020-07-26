package leetcode.week05.day01;

import java.util.HashMap;

/**
 * 请你设计一个日志系统，可以流式接收日志以及它的时间戳。
 *
 * 该日志会被打印出来，需要满足一个条件：当且仅当日志内容 在过去的 10 秒钟内没有被打印过。
 *
 * 给你一条日志的内容和它的时间戳（粒度为秒级），如果这条日志在给定的时间戳应该被打印出来，则返回 true，否则请返回 false。
 *
 * 要注意的是，可能会有多条日志在同一时间被系统接收。
 *
 * 示例：
 *
 * Logger logger = new Logger();
 *
 * // 日志内容 "foo" 在时刻 1 到达系统 logger.shouldPrintMessage(1, "foo"); returns true;
 *
 * // 日志内容 "bar" 在时刻 2 到达系统 logger.shouldPrintMessage(2,"bar"); returns true;
 *
 * // 日志内容 "foo" 在时刻 3 到达系统 logger.shouldPrintMessage(3,"foo"); returns false;
 *
 * // 日志内容 "bar" 在时刻 8 到达系统 logger.shouldPrintMessage(8,"bar"); returns false;
 *
 *
 *
 * // 日志内容 "foo" 在时刻 10 到达系统 logger.shouldPrintMessage(10,"foo"); returns false;
 *
 * // 日志内容 "foo" 在时刻 11 到达系统 logger.shouldPrintMessage(11,"foo"); returns true;
 *
 * 思路：我们可以用一个双端队列维护所有出现过的日志，然后去掉那些过期的，保证队列里是十秒内的就ok，但是费时间。
 *
 * 我的思路是一个map记录最后一次出现的时间，新日志请求去查一下map即可，这样做的好处是速度快，坏处是map的空间可能会无限扩张，这时你可以定时或者定量去删掉过期的记录
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day01
 * hyp create at 20-6-26
 **/
public class MyLogger {
    private HashMap<String, Integer> msgDict;

    /**
     * Initialize your data structure here.
     */
    public MyLogger() {
        msgDict = new HashMap<String, Integer>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        //没出现过
        if (!msgDict.containsKey(message) || timestamp - msgDict.get(message) >= 10) {
            //未出现，或时间差超过十秒
            msgDict.put(message, timestamp);
            return true;
        } else {
            //十秒内出现过
            return false;
        }
    }
}
