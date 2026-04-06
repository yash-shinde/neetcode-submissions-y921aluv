class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        for(int i = 0 ;i < n ;i ++){
            int[] pair = new int[]{i,heights[i]};
            while(!stack.isEmpty() &&
             stack.peek()[1] > pair[1]){
                //pop
                int[] popped = stack.pop();
                maxArea = Math.max(maxArea,popped[1] * (i - popped[0]));
                pair[0] = popped[0];
            }
            stack.push(pair);
        }

        while(!stack.isEmpty()){
            int[] popped = stack.pop();
            maxArea = Math.max(maxArea,popped[1] * (n - popped[0]));
        }
        return maxArea;
    }
}
