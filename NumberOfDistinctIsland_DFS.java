
class Solution {
    
    void dfs(int i, int j, int pi, int pj, int[][] grid, int[][] vis, ArrayList<String> list)  {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0 ||
            vis[i][j] == 1)
            return;
        vis[i][j] = 1;
        list.add(i - pi + "_" + (j - pj));
        
        int[] di = {0, -1, 0, 1};
        int[] dj = {-1, 0, 1, 0};
        
        for(int k=0;k<4;k++) {
            dfs(di[k] + i, dj[k] + j, pi, pj, grid, vis, list);
        }
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        
        Set<ArrayList<String>> set = new HashSet<>();
        ArrayList<String> list;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    list = new ArrayList<>();
                    dfs(i, j, i, j, grid, vis, list);
                    set.add(list);
                }
            }
        }
        
        return set.size();
    }
}
