class Solution {
    public boolean dfs(int node, int[] path, int[] vis, List<List<Integer>> adj) {
        vis[node] = 1;
        path[node] = 1;
        for(int it : adj.get(node)) {
            if(path[it] == 1)
                return true;
            if(vis[it] == 0 && dfs(it, path, vis, adj))
                return true;
        }
        path[node] = 0;
        return false;
    }
    public boolean canFinish(int v, int[][] edges) {
        int[] vis = new int[v];
        int[] path = new int[v];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++) {
            adj.get(edges[i][0])
                .add(edges[i][1]);
        }
        for(int i=0;i<v;i++)
        {
            if(vis[i] == 0) {
                if(dfs(i, path, vis, adj))
                    return false;
            }
        }
        return true;
    }
}