package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {
    public static void main(String[] args) {
        int[] arr={10, 22, 12, 3, 0, 6};
        System.out.println(superiorElements(arr));
    }
    public static List< Integer > superiorElements(int []a) {
        List<Integer> ans=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for (int i=a.length-1;i>=0;i--){
            if(a[i]>max){
                ans.add(a[i]);
                max=a[i];
            }
        }
        return ans;
    }
}
