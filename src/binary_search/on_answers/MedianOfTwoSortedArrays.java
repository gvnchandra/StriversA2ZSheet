package binary_search.on_answers;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 1, 5, 11, 12, 12, 14, 14, 16, 17}, b = {11, 15, 20, 20, 20, 20};
        System.out.println(median(a, b));
    }

    public static double median(int[] a, int[] b) {
        if (b.length < a.length)
            return median(b, a);
        int n1 = a.length, n2 = b.length;
        int low = 0, high = n1;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : a[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : b[cut2];
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}
