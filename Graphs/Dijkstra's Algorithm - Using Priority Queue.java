class Pair {
    int node;
    int distance;
    public Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
class Solution {
    public int[] dijkstra(int v, int[][] edges, int src) {
        // code here
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        queue.add(new Pair(0, src));
        
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2], edges[i][0]));
        }
        
        int[] dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        
        while(!queue.isEmpty()) {
            Pair top = queue.poll();
            if(top.distance > dis[top.node]) continue;
            for(Pair pair : adj.get(top.node)) {
                int adjNodeDistance = top.distance + pair.distance;
                if(adjNodeDistance < dis[pair.node]){
                    queue.add(new Pair(adjNodeDistance, pair.node));
                    dis[pair.node] = adjNodeDistance;
                }
            }
        }
        
        return dis;
    }
}
