package binary_search.on_answers;

public class CapacityToShipPackages {
    public static void main(String[] args) {
        int n = 8, d = 12;
        int[] arr = {86, 45, 74, 64, 14, 68, 44, 11, 43, 33, 8, 20};
        System.out.println(leastWeightCapacity(arr, d));
    }

    public static int leastWeightCapacity(int[] weights, int d) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        //86, 45, 74, 64, 14, 68, 44, 11, 43, 33, 8, 20
        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean possible = f(weights, mid, d);
            if (possible)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    static boolean f(int[] weights, int maxCap, int noOfDays) {
        int count = 0, cap = 0;
        for (int i = 0; i < weights.length; i++) {
            cap += weights[i];
            if (cap > maxCap) {
                count += 1;
                cap = weights[i];
            }
        }
        count += 1;
        return count <= noOfDays;
    }
}
