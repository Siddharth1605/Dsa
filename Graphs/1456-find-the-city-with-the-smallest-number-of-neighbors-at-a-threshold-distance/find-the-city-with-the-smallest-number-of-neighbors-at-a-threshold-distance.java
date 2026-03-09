class Solution {
    public int findTheCity(int n, int[][] edges, int t) {
        int[][] adj = new int[n][n];
        int INF = (int)1e8;
        for(int[] it : adj)
            Arrays.fill(it, INF);
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(i == j)
                    adj[i][j] = 0;
        for(int[] it : edges)
        {
            int u = it[0];
            int v = it[1];
            int w = it[2];
            adj[u][v] = w;
            adj[v][u] = w;
        }
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(adj[i][k] != INF && adj[k][j] != INF && adj[i][j] > adj[i][k] + adj[k][j]) {
                            adj[i][j] = adj[i][k] + adj[k][j];
                        }
                }
            }
        }
        int minCount = INF;
        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=0;j<n;j++) {
                if(i!=j && adj[i][j] <= t)
                    count++;
            }
            minCount = Math.min(minCount, count);
        }

        int ans = 0;
        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=0;j<n;j++) 
                if(i!=j && adj[i][j] <= t)
                    count++;
            ans = (count == minCount) ? i : ans;
        }
        return ans;
    }
}