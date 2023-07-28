package arrays.medium;

public class MajorityElement {
    public static void main(String[] args) {
        int n = 9;
        int[] arr = {2, 2, 1, 3, 1, 1, 3, 1, 1};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] v) {
        //By using Moore voting algorithm
        int c = 0, ele = -1;
        for (int i = 0; i < v.length; i++) {
            if (c == 0)
                ele = v[i];
            if (ele == v[i])
                c++;
            else
                c--;
        }
        return ele;
    }
}
