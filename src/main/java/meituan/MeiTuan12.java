package meituan;

/**
 * <pre>
 * https://leetcode-cn.com/problems/FvoBGh/
 *  Created by pingxin on 2022/2/28.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/28
 */

import java.io.*;
import java.util.Arrays;

public class MeiTuan12 {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    /**
     * 贪心： 按照组合价格排序
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //三个正整数 M，N，Q，
        // 表示小美书架有 N 行编号 1 到 N ，
        // 书本编号从 1 到 M ，
        // 接下来有 Q 个操作
        /**
         * - 接下来 Q 行，每行是下列操作中的一种：
         *   1. x y : x 是书本的编号，y 是书架的行编号，代表小美将编号为 x 的书本放置到 y 行上。若该书本在小团手上则放置无效，若原来该书在书架上且原行上锁则放置无效，若该书被放置到一个锁了的行上则放置无效。
         *   2. y : y 是书架的行编号，代表小美将行编号为 y 的书架加锁，对已经上锁的书架行该操作无效。
         *   3. y : y 是书架的行编号，代表小美将行编号为 y 的书架锁去掉，对无锁的书架行该操作无效。
         *   4. x : x 是书本的编号，代表小团想借编号为 x 的书本，对该操作若可以借到输出一行正整数在哪一行，借不到输出一行 -1
         *   5. x : x 是书本的编号，代表小团还回来编号为 x 的书本。若该书本不在小团手上该操作无效。
         */
        int N = nextInt(), M = nextInt(), Q = nextInt();
        //编号为i的书在书架第bookshelf[i]行
        int[] bookshelf = new int[N + 1];
        //记录哪些行有上锁
        boolean[] isLock = new boolean[M + 1];
        //记录小团借了哪些书
        int[] hasBook = new int[N + 1];
        Arrays.fill(bookshelf, -1);
        for (int i = 0; i < Q; i++) {
            //1:放书  2:对行上锁  3:对行去锁  4:借书  5:还书
            int oper = nextInt(), x, y;
            switch (oper) {
                case 1:
                    x = nextInt();
                    y = nextInt();
                    //没有放置到一个锁了的行上 并且 该书本不在小团手上
                    //并且 (原来该书不在书架上 或 原来该书在书架上且原行没上锁)
                    if (!isLock[y]
                            &&
                            hasBook[x] != 1
                            &&
                            (bookshelf[x] == -1 || !isLock[bookshelf[x]])
                    ) {
                        //把编号为x的书放到y行书架
                        bookshelf[x] = y;
                    }
                    break;
                case 2:
                    y = nextInt();
                    isLock[y] = true;
                    break;
                case 3:
                    y = nextInt();
                    isLock[y] = false;
                    break;
                case 4:
                    x = nextInt();
                    y = bookshelf[x];
                    //如果可以借到书(书本在书架上,且该行没上锁,且不在小团手上)
                    if (y != -1 && !isLock[y] && hasBook[x] != 1) {
                        out.println(y);
                        //更新小团借的书
                        hasBook[x] = 1;
                        //将书架上对应位置置空
                        bookshelf[x] = -1;
                    } else {
                        out.println(-1);
                    }
                    break;
                case 5:
                    x = nextInt();
                    //还书
                    if (hasBook[x]!=0){
                        hasBook[x] = 0;
                    }
                    break;
                default:

            }
        }
        out.flush();
        out.close();
    }
}
//5 5 10
//1 1 4
//1 2 3
//1 3 1
//2 1
//4 1
//5 2
//4 3
//4 5
//3 1
//4 2