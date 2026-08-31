class Solution {
    public int rob(int[] nums) {
        return spaceOptimized(nums);
    }

    private int usingDp(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2 ; i < n ; i++){
            dp[i] =  Math.max(nums[i] +dp[i-2],dp[i-1]);
        }

        return dp[n-1];
    }

    private int spaceOptimized(int[] nums){
        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
