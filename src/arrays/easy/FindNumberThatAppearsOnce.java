package arrays.easy;

public class FindNumberThatAppearsOnce {
    public static void main(String[] args) {
        int n=7;
        int[] arr={1,1,2,2,3};
        System.out.println(getSingleElement(arr));
    }

    public static int getSingleElement(int [] nums){
        //However the solution is failing for one testcase in codestudio
        int xor=0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
