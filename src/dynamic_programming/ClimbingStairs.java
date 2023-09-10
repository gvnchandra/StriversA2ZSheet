package dynamic_programming;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(countDistinctWayToClimbStair(n));
    }

    public static int countDistinctWayToClimbStair(long nStairs) {
        // Write your code here.
        if (nStairs == 0)
            return 1;
        if (nStairs == 1)
            return 1;
        return countDistinctWayToClimbStair(nStairs - 1) + countDistinctWayToClimbStair(nStairs - 2);
    }
}
