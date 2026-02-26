class Pair {
    int node;
    int distance;
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int[] shortestPath(int v, int[][] edges, int src) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0));
        while(!queue.isEmpty()) {
            Pair top = queue.remove();
            for(int it : adj.get(top.node)) {
                
                int adjDistance = top.distance + 1;
                if(dis[it] > adjDistance) {
                    dis[it] = adjDistance;
                    queue.add(new Pair(it, adjDistance));
                }
            }
        }
        for(int i=0;i<v;i++)
            if(dis[i] == Integer.MAX_VALUE)
                dis[i] = -1;
        return dis;
    }
}
