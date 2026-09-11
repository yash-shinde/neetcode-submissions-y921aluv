class Solution {
    public int maxProduct(int[] nums) {
        int curMax = 1 , curMin = 1; 
        int res = nums[0];

        for(int num : nums){
            int inclCurMax = curMax * num;
            int inclCurMin = curMin * num;

            curMax = Math.max(num, Math.max(inclCurMax,inclCurMin));
            
            curMin = Math.min(num, Math.min(inclCurMax,inclCurMin));

            res = Math.max(res,curMax);
        }

        return res;
    }
}
