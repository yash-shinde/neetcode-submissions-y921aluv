class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,nums.length-k);
    }

    private int quickSelect(int[] nums,int k){
        int L = 0 , R = nums.length-1;
        int pivotIdx = nums.length;

        while(pivotIdx != k){
            pivotIdx = partition(nums,L,R);
            if(pivotIdx == k) return nums[pivotIdx];
            else if(pivotIdx < k) L = pivotIdx +1;
            else R = pivotIdx -1;
        }

        return nums[L];
    }

    private int partition(int[] nums,int l , int r){
        int pivot = nums[r];
        int p = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }

        int temp = nums[p];
        nums[p] = nums[r];
        nums[r] = temp;
        
        return p;
    }


}
