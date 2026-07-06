class Solution {
    //at each step we decide whether we want to include current no or skip it
    //we get to reuse the no multiple times
    //our stopping condition is if the target == curr sum
    //or we are out of elements or curr ssum > target

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList();
        backtrack(nums, target, cur, 0);
        return res;
    }

    private void backtrack(int[] nums,int target,List<Integer> cur,int i){
        if(target ==0){
            res.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur, i);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i + 1);
    }




}
