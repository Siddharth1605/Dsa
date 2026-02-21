class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int[] vis = new int[v];
        int[] path = new int[v];
        int[] check = new int[v];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<v;i++) {
            if(vis[i] == 0) {
                dfs(i, vis, path, graph, check);
            }
        }
        for(int i=0;i<v;i++) {
            if(check[i] == 1)
                ans.add(i);
        }
        return ans;
    }

    public boolean dfs(int node, int[] vis, int[] path, int[][] graph, int[] check) {
        vis[node] = 1;
        path[node] = 1;
        for(int it : graph[node]) {
            if(path[it] == 1)
                return false;
            if(vis[it] == 0 && dfs(it, vis, path, graph, check) == false)
                return false;
        }
        path[node] = 0;
        check[node] = 1;
        return true;
    }
}