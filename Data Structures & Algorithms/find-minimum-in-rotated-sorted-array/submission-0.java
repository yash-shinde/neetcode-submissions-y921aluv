class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        //this method zeroes in on the minimum 
        //this is the way to find the lower bound
        while(l<r){
            int m = l + (r-l)/2;
            if(nums[m] < nums[r]){
                //sorted part //m could still be the minimum
                //or ans could be in the left half
                r = m;
            }else{
                //in this case the ans is in the right half
                l = m+1;
            }
        }
        return nums[l];
    }
}
