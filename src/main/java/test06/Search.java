package test06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test06
 * hyp create at 19-10-31
 **/
public class Search {

    private static Random random = new Random();

    public static void main(String[] argv) {
        int[] arr = makeData();
        int target = random.nextInt() % 100;

        System.out.println("查找表:" + Arrays.toString(arr));
        System.out.println("目标数值:" + target);
        //顺序查找
        //testTime("顺序查找", arr, target);

        //先排序
        Arrays.sort(arr);
        //二分查找
        testTime("二分查找", arr, target);

        //插值查找
        //testTime("插值查找",arr,target);
    }

    private static int[] makeData() {

        int len = 100000;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt() % 100000;
        }
        return arr;
    }

    private static void testTime(String name, int[] arr, int target) {
        System.out.println("算法名称：" + name);
        long d = System.currentTimeMillis();

        System.out.println("查找结果：" + interpolationSearch(arr, target));
        System.out.println("耗时:" + (System.currentTimeMillis() - d));
    }

    public static int sequentialSearch(int[] arr, int key) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int binarySearch(int[] arr, int key) {
        int index = -1;

        int bom = 0, top = arr.length - 1, mid;
        while (bom <= top) {
            if (key == arr[bom]) {
                index = bom;
                break;
            }
            if (key == arr[top]) {
                index = top;
                break;
            }
            mid = (bom + top) / 2;
            if (key == arr[mid]) {
                index = mid;
                break;
            } else if (key > arr[mid]) {
                bom = mid + 1;
            } else {
                top = mid - 1;
            }
        }

        return index;
    }

    public static int interpolationSearch(int[] arr, int key) {
        int index = -1;

        int bom = 0, top = arr.length - 1, mid;
        while (bom <= top) {
            if (key == arr[bom]) {
                index = bom;
                break;
            }
            if (key == arr[top]) {
                index = top;
                break;
            }
            mid = bom + (key - arr[bom]) / (arr[top] - arr[bom] * (top - bom));
            if (key == arr[mid]) {
                index = mid;
                break;
            } else if (key > arr[mid]) {
                bom = mid + 1;
            } else {
                top = mid - 1;
            }
        }

        return index;
    }
}
