package test04;

import java.util.List;

/**
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *https://blog.csdn.net/qq_41855420/article/details/88421118
 * 示例 1:
 *
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2:
 *
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 *
 * 四种情况：
 *
 * 数组里有空字符串，并且数组里还有自己就是回文的字符串，每出现一个可与空字符串组成两对。
 * 如果自己的翻转后的字符串也在数组里，可以组成一对，注意翻转后不能是自己。
 * 如果某个字符串能找到一个分割点，分割点前的部分是回文，后半部分翻转后也在数组里，可组成一对。
 * 把3反过来，如果后部分是回文，前半部分翻转后在数组里，可组成一对。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test04
 * hyp create at 19-8-16
 **/
public class Test04 {
//    将所有字符串储存到Dictionnary中，对每个字符串，讨论四种情况:
//
//若该字符串为回文字符串且字典里有空字符串，添加两次（一正一反）
//若该字符串不为回文字符串且字典里有该字符串的反转，添加
//如果某个字符串能找到一个分割点，分割点前的部分是回文，后半部分翻转后也在数组里，添加
//如果某个字符串后部分是回文，前半部分翻转后在数组里，添加

//    public List<List<Integer>> palindromePairs(String[] words) {
//
//    }
}

