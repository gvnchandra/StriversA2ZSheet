package arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        //problem type 2
        //Printing the entire row
        int n = 6;
        System.out.println(model1(n));

        n = 5;
        System.out.println(pascalTriangle(n));
    }

    public static List<Integer> model1(int N) {
        //the observation is for suppose if n=5
        /*                    1
         *                   1   1
         *               1     2   1
         *             1   3     3   1
         *     -> 1   4    6    4   1
         *         1   5    10  10   5  1
         * */
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int mul = 1;
        for (int i = 1; i < N; i++) {
            mul = mul * (N - i) / i;
            ans.add(mul);
        }
        return ans;
    }


    public static List<List<Integer>> pascalTriangle(int N) {
        // Write your code here.
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            List<Integer> temp = new ArrayList<>();
            int mul = 1;
            temp.add(mul);
            for (int j = 1; j < i; j++) {
                mul = mul * (i - j) / j;
                temp.add(mul);
            }
            ans.add(temp);
        }
        return ans;
        //return ans.toArray(new int[ans.size()][]);
    }
}
