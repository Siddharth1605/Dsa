class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i=0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int u) {
        if(u == parent.get(u)) 
            return u;
        parent.set(u, findParent(parent.get(u)));
        return parent.get(u);
    }

    public void unionBySize(int u, int v, int upU, int upV) {
        // int upU = findParent(u);
        // int upV = findParent(v);
        // if(upU == upV)
        //     return;
        if(size.get(upU) < size.get(upV)) {
            size.set(upV, size.get(upV) + size.get(upU));
            parent.set(upU, upV);
        } else {
            size.set(upU, size.get(upU) + size.get(upV));
            parent.set(upV, upU);
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        for(int[] it : connections) {
            int u = it[0];
            int v = it[1];
            int upU = ds.findParent(u);
            int upV = ds.findParent(v);
            if(upU == upV) 
                extraEdges++;
            else 
                ds.unionBySize(u, v, upU, upV);
        }
        int individualComponents = 0;
        for(int i=0;i<n;i++)
            if(i == ds.parent.get(i))
                individualComponents++;
        return extraEdges >= individualComponents - 1 ? individualComponents - 1 : -1;
    }
}