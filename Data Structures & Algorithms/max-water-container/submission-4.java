class Solution {
    public int maxArea(int[] heights) {
        //take 2 pointers both at the ends
        //only move the smaller one since that allows us to iterate 
        //over all possibilities
        int l = 0;
        int r = heights.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(l<r){
            maxArea = Math.max(maxArea , (r-l)*(Math.min(heights[l],heights[r])));
            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
