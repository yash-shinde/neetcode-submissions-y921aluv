class Solution {

    private static int[][] memo = new int[1001][1001];

    public int lengthOfLIS(int[] nums) {
         for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0,-1,nums);
    }

    private int dfs(int idx,int prev,int[] nums){
        if(idx == nums.length) return 0; 
        if(prev != -1 && memo[idx][prev] != -1){
            return memo[idx][prev];
        }
        int take = 0;
        if(prev == -1 || nums[prev] < nums[idx]){
            //take this element and go ahead
            take = 1 + dfs(idx+1,idx,nums);
        }

        int skip = dfs(idx+1,prev,nums);
        if(prev != -1){
            memo[idx][prev] = Math.max(take,skip);   
        }
        return Math.max(take,skip);
    }
}
