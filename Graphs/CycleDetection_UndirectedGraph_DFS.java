class Solution {
    public boolean dfs(int node, int parent, int[] visited, List<List<Integer>> adj) {
        
        for(int it : adj.get(node)) {
            if(visited[it] == 0) {
                visited[it] = 1;
                if(dfs(it, node, visited, adj))
                    return true;
            } else if(visited[it] == 1 && parent != it)
            {
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int v, int[][] edges) {
        // Code here
        int[] visited = new int[v];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] it : edges) {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        for(int i=0;i<v;i++) 
        {
            if(visited[i] == 0) {
                visited[i] = 1;
                if(dfs(i, -1, visited, adj))
                    return true;
            }
        }
        return false;
    }
}
