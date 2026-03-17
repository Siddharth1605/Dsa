// User function Template for Java
class Disjointset {
    List<Integer> parent;
    List<Integer> size;
    public Disjointset(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0;i<n;i++){
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

    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        // Your code here
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, -1, 0, 1};
        
        int[][] vis = new int[n][m];
        Disjointset ds = new Disjointset(n*m);
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        for(int[] it : operators) {
            int i = it[0];
            int j = it[1];
            int currentNode = m*i + j;
            if(vis[i][j] == 1){
                ans.add(cnt);
                continue;
            }
            vis[i][j] = 1;
            cnt++;
            for(int k=0;k<4;k++) {
                int adjI = i + di[k];
                int adjJ = j + dj[k];
                if(adjI < 0 || adjI >= n || adjJ < 0 || adjJ >= m || vis[adjI][adjJ] == 0)
                    continue;
                int adjNode = adjI * m + adjJ;
                int ultimateParent = ds.findParent(adjNode);
                int ultimateParentCurrentNode = ds.findParent(currentNode);
                if(ultimateParentCurrentNode != ultimateParent){
                    ds.unionBySize(currentNode, adjNode);
                    cnt--;
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}
