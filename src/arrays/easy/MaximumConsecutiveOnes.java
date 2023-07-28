package arrays.easy;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int n = 6, k = 3;
        int[] vehicle = {0, 1, 0, 0, 1, 0};
        System.out.println(traffic(n, k, vehicle));
    }

    public static int traffic(int n, int m, int[] vehicle) {
        int maxOnes = 0;
        for (int i = 0; i < n; i++) {
            int j = i, ones = 0, converted = 0;
            while (j < n && maxOnes < n - i) {
                if (vehicle[j] == 1) {
                    ones++;
                    j++;
                } else {
                    if (converted < m) {
                        converted++;
                        ones++;
                        j++;
                    } else
                        break;
                }
            }
            maxOnes = Math.max(maxOnes, ones);
        }
        return maxOnes;
    }
}
