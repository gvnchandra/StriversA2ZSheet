package arrays.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementGreaterThan3Times {
    public static void main(String[] args) {
        int[] a = {2, 2, 1, 3, 1, 1, 3, 1, 1};
        System.out.println(majorityElement(a));
    }

    public static List<Integer> majorityElement(int[] v) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;
        for (int i = 0; i < v.length; i++) {
            if (count1 == 0 && ele2 != v[i]) {
                count1 = 1;
                ele1 = v[i];
            } else if (count2 == 0 && ele1 != v[i]) {
                count2 = 1;
                ele2 = v[i];
            } else if (ele1 == v[i])
                count1++;
            else if (ele2 == v[i])
                count2++;
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] == ele1)
                count1++;
            else if (v[i] == ele2)
                count2++;
        }
        if (count1 > v.length / 3)
            ans.add(ele1);
        if (count2 > v.length / 3)
            ans.add(ele2);
        Collections.sort(ans);
        return ans;
    }
}
