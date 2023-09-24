package binary_search.on_answers;

public class NthRootM {
    public static void main(String[] args) {
        int n = 3, m = 27;
        System.out.println(NthRoot(n, m));
    }

    static int f(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m)
                return 2;
        }
        if (ans == m)
            return 1;
        return 0;
    }

    public static int NthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int mulValue = f(mid, n, m);
            if (mulValue == 1)
                return mid;
            else if (mulValue == 2)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
