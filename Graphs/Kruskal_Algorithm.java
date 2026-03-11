// User function Template for Java
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
    static int kruskalsMST(int n, int[][] edges) {
        // code here
        List<int[]> edge = new ArrayList<>();
        for(int[] it : edges) {
            edge.add(it);
        }
        edge.sort(Comparator.comparingInt(o -> o[2]));
        DisjointSet ds = new DisjointSet(n);
        int sum = 0;
        for(int[] it : edge) {
            int u = it[0];
            int v = it[1];
            int w = it[2];
            if(ds.isSameComponent(u, v))
                continue;
            ds.unionBySize(u, v);
            sum += w;
        }
        return sum;
    }
}
