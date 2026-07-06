class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> vst = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums,vst,res,curr);
        return res;
    }

    private void backtrack(int[] nums,Set<Integer> vst,List<List<Integer>> res,
    List<Integer> curr){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
        }
        for(int i=0;i<nums.length;i++){
            if(!vst.contains(nums[i])){
                vst.add(nums[i]);
                curr.add(nums[i]);
                backtrack(nums,vst,res,curr);

                curr.remove(curr.size()-1);
                vst.remove(nums[i]);
            }
        }
    }
}
