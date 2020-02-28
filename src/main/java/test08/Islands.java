package test08;

/**
 * 岛问题
 *
 * 题目描述：
 * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
 * 四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
 * 矩阵中有多少个岛？
 * 举例：
 * 0 0 1 0 1 0
 * 1 1 1 0 1 0
 * 1 0 0 1 0 0
 * 0 0 0 0 0 0
 * 这个矩阵中有三个岛。
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-2-28
 **/
public class Islands {

    //判断岛的数量
    public int islandNum(int[][] m){
        if(m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(m[i][j] == 1){
                    res++;
                    infect(m, i, j, N, M);//感染函数
                }
            }
        }
        return res;
    }

    public void infect(int[][] m, int i, int j, int N, int M){
        if(i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        //分别对上下左右感染
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }

    public static void main(String[] args) {
        int[][] m = {
                {0, 0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        Islands islands = new Islands();
        int num = islands.islandNum(m);
        System.out.println(num);
    }
}

