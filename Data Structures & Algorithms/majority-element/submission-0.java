class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        //since post sorting majority element will alwasy occupy the mid element
        return nums[nums.length / 2];
    }
}