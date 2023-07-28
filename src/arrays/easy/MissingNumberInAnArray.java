package arrays.easy;

public class MissingNumberInAnArray {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            xor ^= i;
        }
        return xor ^ nums.length;
    }
}
