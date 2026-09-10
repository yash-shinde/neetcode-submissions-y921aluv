class Solution {
    // private static final int[] dp = new int[101];
    // public int numDecodings(String s) {
    //     Arrays.fill(memo,-1);
    //     int n = s.length();
    //     return solve(0,s,n);
    // }

    // private int solve(int i,String s,int n){
    //     if(memo[i] != -1){
    //         return memo[i];
    //     }
    //     if(i == n){
    //         memo[i] = 1;
    //         return 1;//succcessfull found 1 way
    //     }

    //     if(s.charAt(i) == '0'){
    //         memo[i] = 0;
    //         return 0;//cannot split further
    //     }

    //     int res = solve(i+1,s,n);//split at i

    //     if(i+1<n && (s.charAt(i) == '1' || 
    //     s.charAt(i) == '2' && s.charAt(i+1) <= '6')){
    //        res += solve(i+2,s,n);//take 2 chars and split at i+2
    //     }
    //     memo[i] = res;
    //     return res;
    // }

    public int numDecodings(String s) {
       int n = s.length();
       int[] dp = new int[n+1];
       dp[n] = 1; //for base case
       for(int i = n-1;i>=0;i--){
        if(s.charAt(i) == '0'){
            dp[i] = 0;
        }else{
            dp[i] = dp[i+1];
        if(i+1 < n && (s.charAt(i) == '1' || 
        s.charAt(i) == '2' && s.charAt(i+1) < '7')){
            dp[i] += dp[i+2];
        }
        }        
       }

       return dp[0];
    }
}
