package arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Integer[] arr={1,1,2,2,2,3,3};
        ArrayList<Integer> li = new ArrayList<>(Arrays.asList(arr));
        System.out.println(removeDuplicates(li, arr.length));
    }
    public static int removeDuplicates(ArrayList<Integer> arr, int n) {
        //By using two pointers approach
        int i=0;
        for (int j = 1; j <n ; j++) {
            if(!arr.get(j).equals(arr.get(i))){
                i++;
                arr.set(i, arr.get(j));
            }
        }
        return i+1;
    }
}
