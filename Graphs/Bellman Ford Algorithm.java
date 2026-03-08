// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dis = new int[V];
        int limit = (int)Math.pow(10, 8);
        Arrays.fill(dis, limit);
        dis[src] = 0;

        for(int i=0;i<V;i++) {
           for(int[] edge : edges) {
               int u = edge[0];
               int v = edge[1];
               int w = edge[2];
               if(dis[u] != limit && dis[v] > dis[u] + w) {
                   dis[v] = dis[u] + w;
                   if(i == V-1)
                    return new int[]{-1};
               }
           }
        }
        return dis;
    }
}
