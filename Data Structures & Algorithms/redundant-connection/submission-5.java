class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //solve using kahns
        //all normal nodes will have 1 degree
        //we remove those nodes. In the end only the cycle nodes will remain
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>(n+1);
        int[] indegree = new int[n+1];
for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            //build adj
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            //build indegree
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i] == 1){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            indegree[node]--;
            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 1){
                    q.offer(nei);
                }
            }
        }

        for(int i = edges.length-1;i>=1;i--){
            int u = edges[i][0],v=edges[i][1];
            if(indegree[u] == 2 && indegree[v] > 0)
                return new int[]{u, v};
        }
        
        return new int[0];

    }
}
