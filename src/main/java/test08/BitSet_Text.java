package test08;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-2-27
 **/
public class BitSet_Text {
    public static void main(String[] args) {
        /*创建一个大小没有被指定的位组*/
        /*新位组中的所有位都被初始化为false*/
        BitSet bitSet = new BitSet();


        /*检测一个单词用了几个字母*/
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        char[] getchar = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            int index = getchar[i];
            if (index >= 97 && index <= 122) {
                //小写
                int newindex = index - 96;
                bitSet.set(newindex);
            } else {
                if (index >= 65 && index <= 90) {
                    //大写
                    int newindex = index - 64;
                    bitSet.set(newindex);
                } else {
//                    System.out.println("存在非法字符");
                }

            }
        }

        System.out.print("包含的字母有：");
        for (int j = 0; j < bitSet.size(); j++) {


            boolean cout = bitSet.get(j);
            if (cout == true) {
                int y = 96 + j;
                char x = (char) y;
                System.out.print(x);

            }
        }

    }
}
