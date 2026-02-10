class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(isConnected[i][j] == 1 && i!=j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int c = 0;
        for(int i=0;i<n;i++) {
            if(visited[i] == false) {
                c++;
                dfs(i, visited, adj);
            }
        }
        return c;
    }
    public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for(int it : adj.get(node)) {
            if(visited[it] == false) {
                dfs(it, visited, adj);
            }
        }
    }
}

/*
1. convert matrix to adjacency list
2. write dfs calling
3. write dfs
4. return count
*/