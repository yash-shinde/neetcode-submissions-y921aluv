class Solution {
    public int climbStairs(int n) {
        return usingDpArr(n);
    }

    private int usingDpArr(int n){
        if(n<=2) return n;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3 ; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private int spaceOptimized(int n){
        if(n<=2) return n;
        int one = 1;
        int two = 2;
        for(int i = 3 ; i <= n ; i++){
            int temp = two;
            two = one + two;
            one = temp;
        }
        return two;
    }


}
