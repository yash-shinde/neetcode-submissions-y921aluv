class Solution {
    public boolean validTree(int n, int[][] edges) {
        //use cycle detection in dfs 
        //take care of reverse edges in undirected graphs 
        // track parent and ignore it for cycyle considerations
        //if more than n-1 edges it is not a proper tree
        //if cycle exists then it is not a tree
        if(edges.length > n-1)
            return false;

        //build adj matrix
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visit = new HashSet<>();

        if (!dfs(0, -1, visit, adj)) {
            //cycle detected
            return false;
        }

        return visit.size() == n;
    }

    boolean dfs(int node,int parent,Set<Integer> visit,List<List<Integer>> adj)    {   
        if(visit.contains(node)) return false;

        visit.add(node);

        for(int edg : adj.get(node)){
            if(edg == parent)
                continue;

            if(!dfs(edg,node,visit,adj)){
                //cycle detected
              return  false;
            }
        }
        return true;
    }
}
