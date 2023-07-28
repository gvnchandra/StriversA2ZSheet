package arrays.easy;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 0, 0, 2, 3};
        int[] ans = moveZeros(n, arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] moveZeros(int n, int[] a) {
        // Write your code here.
        //finding first zero
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) return a;
        for (int i = j + 1; i < n; i++) {
            if (a[i] != 0) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                j++;
            }
        }
        return a;
    }
}
