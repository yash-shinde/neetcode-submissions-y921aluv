class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m+1][n+1];

        for (int r = 0; r <= m; r++) {
            for (int c = 0; c <= n; c++) {
                dp[r][c] = Integer.MAX_VALUE;
            }
        }

        
        //build the dp array dest  to source using tabulation
        dp[m-1][n] = 0;
        
        for(int i = m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                dp[i][j] = grid[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
            }
        }

        return dp[0][0];
    }
}