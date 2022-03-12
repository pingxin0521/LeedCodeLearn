package sort;

/**
 * Created By pingx on 2020/12/13.
 * At sort
 */
public class SortCompare {
    public static void main(String[] args) {
        ISort sort = new QuickSort();
        Integer[] arr = {5, 3, 4, 2, 1};
        sort.show(arr, System.out);
        sort.sort(arr, 0, arr.length);
        sort.show(arr, System.out);
    }
}
