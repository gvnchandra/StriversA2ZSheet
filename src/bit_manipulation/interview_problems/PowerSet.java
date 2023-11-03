package bit_manipulation.interview_problems;

import java.util.ArrayList;

public class PowerSet {
    public static void main(String[] args) {
        String s = "abc";
        System.out.print(subsequences(s));
    }

    public static ArrayList<String> subsequences(String str) {
        int n = str.length();
        ArrayList<String> ans = new ArrayList<>();
        for (int num = 0; num <= (1 << n) - 1; num++) {
            StringBuilder st = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0)
                    st.append(str.charAt(i));
            }
            if (!st.toString().isEmpty())
                ans.add(st.toString());
        }
        return ans;
    }
}
