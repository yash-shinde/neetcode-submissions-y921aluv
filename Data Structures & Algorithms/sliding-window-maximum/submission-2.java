class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //with pq we get tc of nlogn 
        //with deque we can get  N.

        //when adding an element we remove all elements smaller than it from the 
        //back of the deque and then insert the element
        //if the front of the deque is falling out of range we remove it
        //then we know what the correct answer is for each.
        int n = nums.length;
        int l=0;int r=0;
        int[] op = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<Integer>();
        while(r<n){
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[r]){
                dq.removeLast();
            }
            dq.addLast(r);

            while(l > dq.getFirst()){
                dq.removeFirst();
            }

            if((r+1) >= k){
                op[l] = nums[dq.getFirst()];
                l++;
            }
            r++;

        }
        return op;
    }
}
