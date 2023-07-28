package arrays.easy;

public class SecondLargestElementInAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
        int[] ans = getSecondOrderElements(arr.length, arr);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

    public static int[] getSecondOrderElements(int n, int[] a) {
        int[] ans = new int[2];
        ans[0] = getSLargestElement(a);
        ans[1] = getSSmallestElement(a);
        return ans;
    }

    private static int getSSmallestElement(int[] a) {
        int smallest = Integer.MAX_VALUE, sSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest) {
                sSmallest = smallest;
                smallest = a[i];
            } else if (a[i] < sSmallest && a[i] != smallest) {
                sSmallest = a[i];
            }
        }
        return sSmallest;
    }

    private static int getSLargestElement(int[] arr) {
        int largest = Integer.MIN_VALUE, sLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] > sLargest && arr[i] != largest) {
                sLargest = arr[i];
            }
        }
        return sLargest;
    }
}