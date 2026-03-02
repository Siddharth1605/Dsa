class Pair {
    int node;
    int distance;
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<List<Pair>> adj = new ArrayList<>();
        
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        
        for(int i=0;i<n+1;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        queue.add(new Pair(1, 0));
        
        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);
        
        while(!queue.isEmpty()) {
            Pair obj = queue.poll();
            int curNode = obj.node;
            int curDis = obj.distance;
            
            for(Pair adjNode : adj.get(curNode)) {
                if(dis[adjNode.node] > curDis + adjNode.distance) {
                    dis[adjNode.node] = curDis + adjNode.distance;
                    parent[adjNode.node] = curNode;
                    queue.add(new Pair(adjNode.node, dis[adjNode.node]));
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int node = n;
        while(node != 1) {
            if(parent[node] == -1)
            {
                List<Integer> res = new ArrayList<>();
                res.add(-1);
                return res;
            }
            list.add(0, node);
            node = parent[node];
        }
        list.add(0, 1);
        list.add(0, dis[n]);

        return list;
    }
}
