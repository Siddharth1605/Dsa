class Solution {
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
                if(!bfs(i, vis, graph))
                    return false;
            }
        }
        return true;
    }
}