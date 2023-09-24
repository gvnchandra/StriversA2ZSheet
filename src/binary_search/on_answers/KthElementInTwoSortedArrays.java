package binary_search.on_answers;

import java.util.ArrayList;
import java.util.Arrays;

public class KthElementInTwoSortedArrays {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 9));
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(1, 4, 8, 10));
        int k = 4;
        System.out.println(kthElement(al1, al2, al1.size(), al2.size(), k));
    }

    public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int n1, int n2, int k) {
        if (b.size() < a.size())
            return kthElement(b, a, n2, n1, k);
        int low = Math.max(0, k - n2), high = Math.min(k, n1);
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a.get(cut1 - 1);
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b.get(cut2 - 1);
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : a.get(cut1);
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : b.get(cut2);
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0;
    }
}
