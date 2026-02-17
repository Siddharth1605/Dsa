
class Solution {
    // Computes the count of land cells not reachable from boundary (enclaves)
    public int numEnclaves(int[][] grid) {
        // Handle empty grid
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        // Fetch dimensions
        int n = grid.length, m = grid[0].length;

        // Create visited matrix initialized to false
        boolean[][] vis = new boolean[n][m];

        // Create a queue for BFS
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // Traverse all boundary cells and enqueue boundary lands
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Check if current cell lies on boundary
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    // If boundary cell is land, mark visited and push to queue
                    if (grid[i][j] == 1 && !vis[i][j]) {
                        vis[i][j] = true;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }

        // Direction vectors for 4-neighborhood
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        // BFS to mark all land cells reachable from boundary
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0], col = cur[1];

            // Explore four directions
            for (int k = 0; k < 4; k++) {
                int nrow = row + delrow[k];
                int ncol = col + delcol[k];

                // Check bounds, unvisited, and land
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = true;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }

        // Count land cells that are not visited (i.e., enclaves)
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) cnt++;
            }
        }
        return cnt;
    }
}
