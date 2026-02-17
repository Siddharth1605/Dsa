class Solution {
    public void dfs(int i, int j, int[][] grid, int[][] vis) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] == 1 || grid[i][j] == 0)
            return;
        vis[i][j] = 1;
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, -1, 0, 1};

        for(int k=0;k<4;k++) {
            dfs(i + di[k], j + dj[k], grid, vis);
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int j=0;j<m;j++)
        {
            dfs(0, j, grid, vis);
            dfs(n-1, j, grid, vis);
        }

        for(int i=0;i<n;i++) {
            dfs(i, 0, grid, vis);
            dfs(i, m-1, grid, vis);
        }
        int c = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) 
                    c++;
            }
        }
        return c;
    }
}