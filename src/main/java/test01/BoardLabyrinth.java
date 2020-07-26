package test01;

import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-3-4
 **/
public class BoardLabyrinth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        in.nextLine();
        char[][] data = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = in.nextLine();
            data[i] = line.toCharArray();
        }
        int x = in.nextInt();
        int y = in.nextInt();
        //计数
        int count = 0;
        //标记擦除
        char a = '0';
        //记录方向
        int b = 0;
        while (x > 0 && x <= N && y > 0 && y <= M) {
            char c = data[x - 1][y - 1];
            switch (c) {
                case 'N':
                    data[x - 1][y - 1] = a;
                    x--;
                    b = 1;
                    break;
                case 'S':
                    data[x - 1][y - 1] = a;
                    x++;
                    b = 2;
                    break;
                case 'W':
                    data[x - 1][y - 1] = a;
                    y--;
                    b = 3;
                    break;
                case 'E':
                    data[x - 1][y - 1] = a;
                    y++;
                    b = 4;
                    break;
                case '0':
                    switch (b) {
                        case 1:
                            x--;
                            break;
                        case 2:
                            x++;
                            break;
                        case 3:
                            y--;
                            break;
                        case 4:
                            y++;
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
            count++;
        }
        System.out.println(count);

    }
}
