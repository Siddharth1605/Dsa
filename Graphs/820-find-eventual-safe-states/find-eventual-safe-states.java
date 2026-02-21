class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int[] vis = new int[v];
        int[] path = new int[v];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<v;i++) {
            if(vis[i] == 0) {
                dfs(i, vis, path, graph, ans);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public boolean dfs(int node, int[] vis, int[] path, int[][] graph, List<Integer> ans) {
        vis[node] = 1;
        path[node] = 1;
        for(int it : graph[node]) {
            if(path[it] == 1)
                return false;
            if(vis[it] == 0 && dfs(it, vis, path, graph, ans) == false)
                return false;
        }
        path[node] = 0;
        ans.add(node);
        return true;
    }
}