package leetcode.week07;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    private int distance(int[] p1,int[] p2){
        //为了防止开根号之后出现浮点数，所以直接用距离的平方和
        return (p1[0]- p2[0])*(p1[0]- p2[0])+
                (p1[1]- p2[1])*(p1[1]- p2[1]);

    }

    public int numberOfBoomerangs(int[][] points) {
        //以一个点为基石，再哈希表中判断该点的回旋镖的个数
        int res=0;
        for (int i = 0; i < points.length; i++) {
            //这个哈希表必须在for里面，因为每个点都要有一个哈希表来计算哈希表个数
            //否则只有一个哈希表的话每个点之间就会相互影响
            Map<Integer, Integer> map=new HashMap<>();
            //注意每个点都是从头遍历其他点
            for (int j = 0; j < points.length; j++) {
                if (i!=j){
                    int distance = distance(points[i], points[j]);
                    Integer k = map.getOrDefault(distance, 0);
                    map.put(distance, ++k);
                }
            }
            //既然每个点都有一个哈希表，那么循环结束时就要算出该点中回旋镖的个数
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                res += entry.getValue() * (entry.getValue() -1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,0},{1,0},{2,0}};
        int i = new NumberOfBoomerangs().numberOfBoomerangs(arr);
        System.out.println(i);
    }

}
