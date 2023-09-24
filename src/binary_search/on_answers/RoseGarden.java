package binary_search.on_answers;

public class RoseGarden {
    public static void main(String[] args) {
        int r = 3, b = 2;
        int[] arr = {1, 2, 1, 2, 7, 2, 2, 3, 1};
        System.out.println(roseGarden(arr, r, b));
    }

    public static int roseGarden(int[] arr, int r, int b) {
        long mul = (long) r *b;
        if (mul > arr.length)
            return -1;
        //By using binary search
        int ma = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            ma = Math.max(ma, arr[i]);
        }
        int low = 1, high = ma;
        while (low <= high) {
            int mid = (low + high) / 2;
            int ret = f(arr, mid, r, b);
            if (ret == 1)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    static int f(int[] arr, int noOfDays, int r, int b) {
        int i = 0, nob = 0;
        while (i < arr.length) {
            int count = 0;
            while (i < arr.length && noOfDays >= arr[i]) {
                count++;
                i++;
            }
            i++;
            nob += count / r;
        }
        return (nob >= b) ? 1 : 0;
    }
}
