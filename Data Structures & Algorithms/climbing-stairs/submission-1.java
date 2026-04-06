class Solution {
    public int climbStairs(int n) {
        //for any n the distinct ways is ways(i-1) + ways(i-2)
        //we keep a dp array with dp[0] = dp[1] = 1
        //in the end return dp[n-1] tc 0n
        int no_of_ways = 1;
        int one_before = 1;
        int two_before = 1;
        for(int i = 2 ;i <= n ;i++){
            no_of_ways = one_before + two_before;
            two_before = one_before;
            one_before = no_of_ways;
        }
        return no_of_ways;
    }
}
