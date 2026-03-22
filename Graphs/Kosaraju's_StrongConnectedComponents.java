class Solution {
    public static void dfs(int node, int[] visited, List<List<Integer>> adj, Stack<Integer> stack) {
        if(visited[node] == 1)
            return;
        visited[node] = 1;
        for(int adjNode : adj.get(node)) {
            dfs(adjNode, visited, adj, stack);
        }
        stack.push(node);
    }
    public static void dfs1(int node, int[] visited, List<List<Integer>> adj) {
        if(visited[node] == 1)
            return;
        visited[node] = 1;
        for(int adjNode : adj.get(node)) {
            dfs1(adjNode, visited, adj);
        }
    }
    // Function to find number of strongly connected components in the graph
    public int kosaraju(int v, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i=0;i<v;i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }
        for(int[] it : edges) {
            adj.get(it[0]).add(it[1]);
            revAdj.get(it[1]).add(it[0]);
        }
        int[] visited = new int[v];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<v;i++) {
            if(visited[i] == 0)
                dfs(i, visited, adj, stack);
        }
        int count = 0;
        Arrays.fill(visited, 0);
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if(visited[node] == 0){
                dfs1(node, visited, revAdj);
                count++;
            }
        }
        return count;
    }
}
