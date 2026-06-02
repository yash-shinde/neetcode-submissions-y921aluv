class Solution {
    public int majorityElement(int[] nums) {
        int majorityElem = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==majorityElem)count++;
            else{
                if(count==1){
                    majorityElem = nums[i];
                }
            }
        }
        return majorityElem;
    }
}