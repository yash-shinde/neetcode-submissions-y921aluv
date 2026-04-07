class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1]==1)
            return 0;//source or dest is blocked
        
        int[][] dp = new int[m+1][n+1];
        //build the dp array dest  to source using tabulation
        dp[m-1][n-1] = 1;
        
        for(int i = m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(obstacleGrid[i][j]==1)
                    dp[i][j] = 0;
                else dp[i][j] += dp[i][j+1] + dp[i+1][j];
            }
        }

        return dp[0][0];
    }
}