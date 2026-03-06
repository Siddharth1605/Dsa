class Pair {
    int node;
    long distance;
    public Pair(int node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        long[] dis = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dis, Long.MAX_VALUE);

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->Long.compare(a.distance,b.distance));

        dis[0] = 0;
        ways[0] = 1;
        queue.add(new Pair(0, 0));
        int mod = (int)(1e9 + 7);

        while(!queue.isEmpty()) {
            Pair top = queue.poll();
            for(Pair adjElement : adj.get(top.node)) {
                if(dis[adjElement.node] > top.distance + adjElement.distance) {
                    dis[adjElement.node] = top.distance + adjElement.distance;
                    ways[adjElement.node] = ways[top.node];
                    queue.add(new Pair(adjElement.node, dis[adjElement.node]));
                }
                else if (dis[adjElement.node] == top.distance + adjElement.distance) {
                    ways[adjElement.node]=(ways[top.node] + ways[adjElement.node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}