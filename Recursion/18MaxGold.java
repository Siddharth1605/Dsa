class Solution {
    public static int fun(int i, int j, int[][] grid, int n, int m, int[][] visitor)
    {
        if (i < 0 || i >= n || j < 0 || j >= m || visitor[i][j] == 1 || grid[i][j] == 0) {
            return 0;
        }
        int u = 0;
        int l = 0;
        int b = 0;
        int r = 0;

        //bottom
        if(i<n-1 && visitor[i+1][j] == 0 && grid[i+1][j] != 0)
        {
            visitor[i][j] = 1;
            b = fun(i+1, j, grid, n, m, visitor);
            visitor[i][j] = 0;
        }

        //right
        if(j<m-1 && visitor[i][j+1] == 0 && grid[i][j+1] != 0)
        {
            visitor[i][j] = 1;
            r = fun(i, j+1, grid, n, m, visitor);
            visitor[i][j] = 0;
        }

        //left
        if(j>0 && visitor[i][j-1] == 0 && grid[i][j-1] != 0)
        {
            visitor[i][j] = 1;
            l = fun(i, j-1, grid, n, m, visitor);
            visitor[i][j] = 0;
        }

        //up
        if(i>0 && visitor[i-1][j] == 0 && grid[i-1][j] != 0)
        {
            visitor[i][j] = 1;
            u = fun(i-1, j, grid, n, m, visitor);
            visitor[i][j] = 0;
        }
        
        int ans1 = Math.max(u , b);
        int ans2 = Math.max(l, r);
        return grid[i][j] + Math.max(ans1, ans2);

    }
    public int getMaximumGold(int[][] grid) {
        int x = 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][] visitor = new int[n][m];

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                visitor[i][j] = 0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] != 0)
                    x = Math.max(x, fun(i, j, grid, n, m, visitor));
            }
        }

        return x;
    }
}