class Solution {
    public int findDuplicate(int[] nums) {
        //start of LL
        int slow=0,fast =0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        //start at head to get to the start of cycle
        int slow2 =0;
        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2){
                return slow;
            }
        }
    }
}
