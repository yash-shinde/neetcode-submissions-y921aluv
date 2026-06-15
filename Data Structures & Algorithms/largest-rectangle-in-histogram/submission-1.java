class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                //curr elem is right boundary for stack top
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea , (height *(i-index)));
                //index is left boundary for curr elem
                start  = index;
            }
            stack.push(new int[]{start,heights[i]});
        }

        //only elements left in stack 
        for(int[] top : stack){
            int index = top[0];
            int height = top[1];
            maxArea = Math.max(maxArea , (height *(heights.length-index)));
        }

        return maxArea;
    }
}
