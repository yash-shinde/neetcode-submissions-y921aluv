class Solution {
    public int climbStairs(int n) {
        //for any n the distinct ways is ways(i-1) + ways(i-2)
        //we keep a dp array with dp[0] = dp[1] = 1
        //in the end return dp[n-1] tc 0n
        int[] dp = new int[n+1];
        dp[0]=dp[1]=1;
        for(int i = 2 ;i <= n ;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
