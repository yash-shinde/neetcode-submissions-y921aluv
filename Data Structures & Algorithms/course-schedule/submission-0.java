class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //use kahns to remove elements with zero indegree
        int[] indegree = new int[numCourses];
        //keep track of the adjacency matrix
        List<List<Integer>> adj = new ArrayList<>();
        
        //build the adj matrix
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        //calculate the indegrees for each
        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        //for all elements with zero indegree add them to the queue
         Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        //keep track of how many courses are removed 
        int finish = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            finish++;

            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }

        return finish == numCourses;
    }
}
