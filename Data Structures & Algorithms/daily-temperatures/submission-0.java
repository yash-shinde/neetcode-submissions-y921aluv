class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<int[]>();
        for(int i =0 ; i < n;i++){
            int curr = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[0] < 
            curr){
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];//index
            }
            stack.push(new int[]{curr,i});
        }
        return res;
    }
}
