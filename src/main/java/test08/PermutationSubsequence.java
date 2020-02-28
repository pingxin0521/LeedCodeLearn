package test08;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-2-27
 **/
public class PermutationSubsequence {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        in.nextLine();
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
//        System.out.println(solution(arr));


        System.out.println(solution(new int[]{1, 2, 0, 2, 2, 1}));
    }

    private static int solution(int[] arr) {
        int n = arr.length;
        int count = n;
        if (n > 1) {
            boolean asc = arr[0] < arr[1];
            count--;
            for (int i = 2; i < n; i++) {

                if ((asc && arr[i] >= arr[i - 1]) || (!asc && arr[i] <= arr[i - 1])) {
                    count--;
                    continue;
                }

                if (i < n - 1) {
                    asc = arr[i] < arr[i + 1];
                }
            }
        }

        return count;
    }
}
