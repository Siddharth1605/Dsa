class Detail {
    int node;
    int price;
    int stops;
    public Detail(int node, int price, int stops) {
        this.node = node;
        this.price = price;
        this.stops = stops;
    }
    public Detail(int node, int price) {
        this.node = node;
        this.price = price;
        this.stops = 0;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flight, int src, int dst, int k) {
        List<List<Detail>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        Queue<Detail> queue = new LinkedList<>();
        queue.add(new Detail(src, 0, 0));
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for(int i=0;i<flight.length;i++) 
            adj.get(flight[i][0]).add(new Detail(flight[i][1], flight[i][2]));

        while(!queue.isEmpty()) {
            Detail top = queue.poll();
            if(top.stops > k)
                continue;
            for(Detail adjNode : adj.get(top.node)) {
                if(top.stops <= k && cost[adjNode.node] > top.price + adjNode.price) {
                    cost[adjNode.node] = top.price + adjNode.price;
                    queue.add(new Detail(adjNode.node, cost[adjNode.node], top.stops + 1));
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}