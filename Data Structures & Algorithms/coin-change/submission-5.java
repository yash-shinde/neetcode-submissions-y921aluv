class Solution {
    // Map<Integer,Integer> memo = new HashMap<>();
    // public int coinChange(int[] coins, int amount) {
    //     memo.put(0,0);
    //     int minCoins = dfs(coins,amount);
    //     return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    // }

    // private int dfs(int[] coins,int amount){
    //     if(memo.containsKey(amount)){
    //         return memo.get(amount);
    //     }

    //     int res = Integer.MAX_VALUE;
    //     for(int coin : coins){
    //        if(amount - coin >= 0){
    //         int result = dfs(coins,amount - coin);
    //         if(result != Integer.MAX_VALUE)
    //             res = Math.min(res,1 + result);
    //        } 
    //     }
    //     memo.put(amount,res);
    //     return res;
    // }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount +1);
        dp[0] = 0;

        for(int i = 1 ; i <= amount ; i++){
            for(int c : coins){
                if(c <= i){
                    dp[i] = Math.min(dp[i],1+dp[i-c]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
