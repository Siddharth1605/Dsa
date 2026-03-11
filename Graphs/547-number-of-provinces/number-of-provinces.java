class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i=0;i<=n;i++) {
            size.add(1);
            parent.add(i);
        }
    }
    
    int findParent(int u) {
        if(u == parent.get(u))
            return u;
        parent.set(u, findParent(parent.get(u)));
        return parent.get(u);
    }
    void unionBySize(int u, int v) {
        int up_u = findParent(u);
        int up_v = findParent(v);
        if(up_u == up_v)
            return;
        if(size.get(up_u) < size.get(up_v))
        {
            size.set(up_v, size.get(up_v) + size.get(up_u));
            parent.set(up_u, up_v);
        }
        else {
            size.set(up_u, size.get(up_u) + size.get(up_v));
            parent.set(up_v, up_u);
        }
    }
    boolean isSameComponent(int u, int v) {
        int up_u = findParent(u);
        int up_v = findParent(v);
        if(up_u == up_v)
            return true;
        return false;
    }
}
class Solution {
    public int findCircleNum1(int[][] isConnected) {
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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j] == 1)
                    ds.unionBySize(i, j);
            }
        }
        int count = 0;
        for(int i=0;i<n;i++)
            if(ds.findParent(i) == i)
                count++;
        return count;
    }
}

/*
1. convert matrix to adjacency list
2. write dfs calling
3. write dfs
4. return count
*/