class Cell {
    int node;
    int parent;
    int weight;
    public Cell(int node, int parent, int weight) {
        this.node = node;
        this.parent = parent;
        this.weight = weight;
    }
    public Cell(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int spanningTree(int n, int[][] edges) {
        // code here
        List<List<Cell>> adj = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] vis = new int[n+1];
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        for(int[] it : edges) {
            adj.get(it[0]).add(new Cell(it[1], it[2]));
            adj.get(it[1]).add(new Cell(it[0], it[2]));
        }
        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        queue.add(new Cell(0, -1, 0));
        int sum = 0; 
        while(!queue.isEmpty()) {
            Cell top = queue.remove();
            if(vis[top.node] != 0)
                continue;
            vis[top.node] = 1;
            sum += top.weight;
            for(Cell adjel : adj.get(top.node)) {
                if(vis[adjel.node] != 0)
                    continue;
                queue.add(new Cell(adjel.node, top.node, adjel.weight));
            }
        }
        return sum;
    }
}
