class Solution {
    public boolean dfs(int node, int[] vis, int[][] graph, int parentColor) {
        if(vis[node] != 0 && vis[node] == parentColor)
            return false;
        if(vis[node] != 0 && vis[node] != parentColor)
            return true;
        vis[node] = (parentColor == 1) ? 2 : 1;
        for(int it : graph[node]) {
            if(!dfs(it, vis, graph, vis[node]))
                return false;
        }
        return true;
    }
    public boolean bfs(int node, int[] vis, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        vis[node] = 1;
        while(!queue.isEmpty()) {
            int top = queue.poll();
            for(int it : graph[top]) {
                if(vis[it] != 0 && vis[it] == vis[top])
                    return false;
                if(vis[it] != 0)
                    continue;
                vis[it] = (vis[top] == 1) ? 2 : 1;
                queue.add(it);
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        for(int i=0;i<n;i++) {
            if(vis[i] == 0)     
            {
                if(!dfs(i, vis, graph, -1))
                    return false;
            }
        }
        return true;
    }
}