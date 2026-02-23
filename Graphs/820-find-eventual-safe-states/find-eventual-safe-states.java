class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int[] indegree = new int[v];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        for(int i = 0; i < v; i++) {
            for(int neighbor : graph[i]) {
                adj.get(neighbor).add(i);
                indegree[i]++;   
            }
        }
        return bfs(indegree, adj);
    }
    public List<Integer> bfs(int[] indegree, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<indegree.length;i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int top = queue.poll();
            ans.add(top);
            for(int it : adj.get(top)) {
                indegree[it]--;
                if(indegree[it] == 0)
                    queue.add(it);
            }
        }

        Collections.sort(ans);
        return ans;
    }
    public List<Integer> eventualSafeNodesDFS(int[][] graph) {
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