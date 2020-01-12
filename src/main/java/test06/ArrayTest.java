package test06;

import java.util.*;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test06
 * hyp create at 19-11-5
 **/
public class ArrayTest {
    private static Random random = new Random();

    public static void main(String[] args) {
//        Integer[] data = makeData(100);
//        System.out.println("数据：" + Arrays.toString(data));
//
//        System.out.println("第二小的元素" + secondSmallest(data));
//
//        System.out.println("第一个不重复的元素" + getFirstNotRepeatNum(data));

        HashSet<Object> hashSet=new HashSet<>();
        Object a=new Object();
        Object b=new Object();
        System.out.println(a.hashCode() + " " + b.hashCode());
        hashSet.add(a);
        hashSet.add(b);
        System.out.println(hashSet);

        hashSet.add("Java");
        hashSet.add("Linux");
        hashSet.add("C++");
        hashSet.add("算法");
        System.out.println(hashSet);
        // 删除 Java
        hashSet.remove("Java");
        // 重新添加 Java
        hashSet.add("Java");
        System.out.println(hashSet);

        TreeSet<Object> treeSet=new TreeSet<>();

        LinkedHashSet books = new LinkedHashSet();
        books.add("Java");
        books.add("Linux");
        books.add("C++");
        books.add("算法");
        System.out.println(books);
        // 删除 Java
        books.remove("Java");
        // 重新添加 Java
        books.add("Java");
        System.out.println(books);



    }

    private static Integer[] makeData(int len) {

        Integer[] arr = new Integer[len];
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt() % 100000;
        }
        return arr;
    }


    /**
     * 第二小的元素
     * 当然有更好的方法就是，在一次遍历中找到最小的两个数，时间复杂度为O(n)
     * <p>
     * 初始化2个最小值,firstmin,secondmin
     * 遍历所有元素,假如当前元素小于firstmin,那么将更新firstmin,secondmin.如果小于secondmin直接更新secondmin
     * O(n)
     *
     * @param arr
     */
    public static int secondSmallest(Integer[] arr) {
        int firstmin = Integer.MAX_VALUE, secondmin = Integer.MAX_VALUE;
        for (Integer v : arr) {
            if (v < firstmin) { //小于最小的元素 更新1和2
                secondmin = firstmin;
                firstmin = v;
            } else if (v < secondmin && v != firstmin) {//小于倒数二的 更新2
                secondmin = v;
            }
        }
        return secondmin;
    }

    /**
     * 找到数组中第一个不重复出现的整数
     * 借助Hash表来解决这个问题。创建一个Hash表，从头到尾遍历一遍数组。
     * 每一个数字作为key，没有的话，新建Entry（数字为key，数量为value）key如果已经存在的话则value+1。
     * 这个算法的时间复杂度是O(n),但是它提高时间效率是以创建一个大小为O(n)的哈希表为代价的。
     * 但是哈希表是无序的啊，如果有多个的Entry满足要求，
     * 取出来的Entry不一定是第一个啊，所以正确思路是使用有序的哈希表
     * 借助有序哈希表，最后遍历哈希表，找到value为1的，它的key就是我们要找的数字，let‘s do it
     *
     * @param arr
     * @return
     */
    public static int getFirstNotRepeatNum(Integer[] arr) {

        int firstNotRepeatNum = 0;
        int matchNumCount = 0;
        LinkedHashMap<Integer, Integer> orderMap =
                new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (orderMap.containsKey(arr[i])) {
                orderMap.put(arr[i], orderMap.get(arr[i]) + 1);
            } else {
                orderMap.put(arr[i], 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator =
                orderMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == 1) {
                matchNumCount += 1;
                firstNotRepeatNum = entry.getKey();
                if (matchNumCount == 1) {
                    break;
                }
            }

        }
        return firstNotRepeatNum;
    }

    /**
     * 合并m个有序数组。
     * 解析：
     * 1）归并排序的变形。两两归并，假设所有元素和为n,由于归并排序的复杂度为O（nlogn),则即使最后一路归并复杂度都至少了O（nlogn)。log为以2为底。
     * 2）将所有的元素放到一个数组中，直接进行排序，复杂度为O（nlogn)。
     * 3）堆排序的变形，使用优先级队列，建立一个m的小堆，复杂度为O（m），每次从堆中取最小值，然后将该值从堆中取出，堆中加入该数的后一个数，当一个数组遍历完后，将无穷大加入到大小为m的堆中。继续构建堆。 复杂度为nlog(m)。
     * @param arrs
     * @return
     */
    public static Integer[] margeSortM(ArrayList<Integer[]> arrs) {
        return null;
    }
}
