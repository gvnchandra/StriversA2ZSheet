package arrays.medium;

import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<Integer> ans = nextGreaterPermutation(li);
        System.out.println(ans);
    }

    public static List<Integer> nextGreaterPermutation(List<Integer> A) {
        // Write your code here.
        //finding the element from the last which is less than next element
        int breakPoint = -1;
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                breakPoint = i;
                break;
            }
        }
        if(breakPoint!=-1){
            for (int i = A.size() - 1; i >= 0; i--) {
                if (A.get(i) > A.get(breakPoint)) {
                    swap(A, i, breakPoint);
                    break;
                }
            }
        }
        reverse(A, breakPoint + 1, A.size() - 1);
        return A;
    }

    static void swap(List<Integer> li, int i, int j) {
        Integer t = li.get(i);
        li.set(i, li.get(j));
        li.set(j, t);
    }

    static void reverse(List<Integer> li, int l, int r) {
        while (l < r) {
            swap(li, l, r);
            l++;
            r--;
        }
    }
}
