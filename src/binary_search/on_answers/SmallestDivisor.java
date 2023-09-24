package binary_search.on_answers;

public class SmallestDivisor {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        System.out.println(smallestDivisor(arr, limit));
    }

    public static int smallestDivisor(int arr[], int limit) {
        //By using binary search
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int low = 1, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sumVal = f(arr, mid);
            if (sumVal <= limit)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    static int f(int[] arr, int mid) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (int) Math.ceil((double) arr[i] / mid);
        }
        return sum;
    }
}
