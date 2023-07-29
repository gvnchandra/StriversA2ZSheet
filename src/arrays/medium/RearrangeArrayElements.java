package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElements {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, -4, -5,2,3};
        //int[] ans = alternateNumbers(arr);
        int[] ans=method1(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] method1(int[] a) {
        //creating two temp arrays
        List<Integer> pos=new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i]>0)
                pos.add(a[i]);
            else
                neg.add(a[i]);
        }
        int min=Math.min(pos.size(), neg.size());
        for (int i = 0; i < min; i++) {
            a[2*i]=pos.get(i);
            a[2*i+1]=neg.get(i);
        }
        int j=2*min;
        if (pos.size()>neg.size()){
            for (int i = min; i <pos.size() ; i++) {
                a[j]=pos.get(i);
                j++;
            }
        }
        else {
            for (int i = min; i <neg.size() ; i++) {
                a[j]=neg.get(i);
                j++;
            }
        }
        return a;
    }

    public static int[] alternateNumbers(int[] a) {
        //The below solution works if array contains equal no.of positives and negatives
        int[] ans = new int[a.length];
        int pi = 0, ni = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                ans[pi] = a[i];
                pi += 2;
            } else {
                ans[ni] = a[i];
                ni += 2;
            }
        }
        return ans;
    }
}
