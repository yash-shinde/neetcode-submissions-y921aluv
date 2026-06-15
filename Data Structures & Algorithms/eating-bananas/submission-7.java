class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(h < piles.length) return -1;
        int hi = Integer.MIN_VALUE;
        int lo = 1;
        for(int i=0;i<piles.length;i++){
            hi = Math.max(hi,piles[i]);
        }
        while(lo<=hi){
            int mid = lo + ((hi-lo)/2);
            if(noOfHrsRequired(piles,mid)>h){
                lo=mid+1;
            }else{
                hi = mid-1;
            }
        }

        return lo;
    }

    //fn to return the no of hrs required
    //no_of_hrs prop.to (capacity)^-1
    private int noOfHrsRequired(int[] piles,int capacity){
        int total = 0;
        for(int i=0;i<piles.length;i++){
            if(piles[i] <= capacity){
                total += 1;
            }else{
                total += Math.ceil((double)piles[i]/capacity);
            }
        }
        return total;
    }
}
