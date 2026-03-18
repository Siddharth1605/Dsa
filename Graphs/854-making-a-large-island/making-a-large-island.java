class Disjointset {
    List<Integer> parent;
    List<Integer> size;
    public Disjointset(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0;i<n;i++) {
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
    public void unionBySize(int u, int v) {
        int upU = findParent(u);
        int upV = findParent(v);
        if(upU == upV)
            return;
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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Disjointset ds = new Disjointset(n*n);
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, -1, 0 , 1};
        int ans = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 0)
                    continue;
                int currentNode = i*n + j; 
                for(int k =0;k<4;k++) {
                    int adjI = di[k] + i;
                    int adjJ = dj[k] + j;
                    if(adjI < 0 || adjI >= n || adjJ < 0 || adjJ >= n || grid[adjI][adjJ] == 0)
                        continue;
                    int adjNode = adjI * n + adjJ;
                    ds.unionBySize(currentNode, adjNode);
                }
                ans = Math.max(ans, ds.size.get(ds.findParent(currentNode)));
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1)
                    continue;
                int currentNode = i*n + j; 
                Set<Integer> set = new HashSet<>();
                int sum = 0;
                for(int k =0;k<4;k++) {
                    int adjI = di[k] + i;
                    int adjJ = dj[k] + j;
                    if(adjI < 0 || adjI >= n || adjJ < 0 || adjJ >= n || grid[adjI][adjJ] == 0)
                        continue;
                    int adjNode = adjI * n + adjJ;
                    set.add(ds.findParent(adjNode));
                }
                for(int it : set)
                    sum += ds.size.get(it);
                ans = Math.max(ans, sum + 1);
            }
        }
    return ans;
    }
}