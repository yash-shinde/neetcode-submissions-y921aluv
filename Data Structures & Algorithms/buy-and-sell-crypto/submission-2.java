class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxProf = 0;
        while(r<prices.length){
            if(prices[r] > prices[l]){
                maxProf = Math.max(prices[r]-prices[l],maxProf);
            }else{
                l = r;
            }
            r++;
        }
        return maxProf;
    }
}
