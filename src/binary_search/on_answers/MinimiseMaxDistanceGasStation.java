package binary_search.on_answers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimiseMaxDistanceGasStation {
    static class Pair {
        double secLen;
        int secIdx;

        public Pair(double secLen, int secIdx) {
            this.secLen = secLen;
            this.secIdx = secIdx;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "secLen=" + secLen +
                    ", secIdx=" + secIdx +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 6;
        System.out.println(MinimiseMaxDistance(arr, k));
    }

    public static double MinimiseMaxDistance(int[] arr, int K) {
        //By using binary search
        double low = 0.0, high = 0.0;
        for (int i = 0; i < arr.length - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }
        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            int count = f(arr, mid);
            if (count > K)
                low = mid;
            else
                high = mid;
        }
        return high;
    }

    static int f(int[] arr, double maxDistance) {
        int noOfGasStationsReq = 0;
        for (int i = 1; i < arr.length; i++) {
            int n = (int) ((arr[i] - arr[i - 1]) / maxDistance);
            if ((arr[i] - arr[i - 1]) == maxDistance * n) {
                n--;
            }
            noOfGasStationsReq += n;
        }
        return noOfGasStationsReq;
    }

    static double method1(int[] arr, int K) {
        int[] howManyStationsPlaced = new int[arr.length - 1];
        Arrays.fill(howManyStationsPlaced, 0);
        for (int i = 1; i <= K; i++) {
            double maxSecLen = 0;
            int maxInd = -1;
            for (int j = 0; j < arr.length - 1; j++) {
                int diff = arr[j + 1] - arr[j];
                double len = (double) diff / (howManyStationsPlaced[j] + 1);
                if (len > maxSecLen) {
                    maxSecLen = len;
                    maxInd = j;
                }
            }
            howManyStationsPlaced[maxInd]++;
        }
        double maxAns = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            maxAns = Math.max(maxAns, (double) diff / (howManyStationsPlaced[i] + 1));
        }
        return maxAns;
    }

    static double method2(int[] arr, int K) {
        //By using heap
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.secLen, a.secLen));
        int[] howManyStationsPlaced = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }
        for (int i = 1; i <= K; i++) {
            Pair top = pq.poll();
            int secIdx = top.secIdx;
            int initDiff = arr[secIdx + 1] - arr[secIdx];
            howManyStationsPlaced[secIdx]++;
            double newLen = (double) initDiff / (howManyStationsPlaced[secIdx] + 1);
            pq.add(new Pair(newLen, secIdx));
        }
        return pq.peek().secLen;
    }

}
