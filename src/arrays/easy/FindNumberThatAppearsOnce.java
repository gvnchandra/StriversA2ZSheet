package arrays.easy;

public class FindNumberThatAppearsOnce {
    public static void main(String[] args) {
        int n=7;
        int[] arr={1,1,2,2,3};
        System.out.println(getSingleElement(arr));
    }

    public static int getSingleElement(int [] nums){
        //However the solution is failing for one testcase in codestudio because of timelimit
//        int xor=0;
//        for (int num : nums) {
//            xor ^= num;
//        }
//        return xor;

        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (mid % 2 != 0) {
                mid -= 1;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
