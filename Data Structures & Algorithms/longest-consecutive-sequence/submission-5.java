class Solution {
    public int longestConsecutive(int[] nums) {
        //use a hashset to store all nos
        //if num - 1 doesnt exist assume it as the start of a seq
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }
        int len = 0;
        int maxLen = 0;
        for(int elem : set){
            if(!set.contains(elem-1)){
                //start of sequence
                len = 1;
                while(set.contains(elem+len)){
                len++;
                }
                maxLen = Math.max(len,maxLen); 
            }
             
        }
        return maxLen;
    }
}
