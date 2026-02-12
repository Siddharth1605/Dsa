class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int colour) {
        int n = image.length;
        int m = image[0].length;
        
        int[][] ans = new int[n][m];
        int[][] visited = new int[n][m];
        if(sr >= n || sc >= m || sr < 0 || sc < 0)
            return image;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                ans[i][j] = image[i][j];
                visited[i][j] = 0;
            }
        }
        flood(image, visited, sr, sc, colour, ans[sr][sc], n, m, ans);
        return ans;
    }
    public static void flood(int[][] image, int[][] visited, int r, int c, int colour, int initial, int n, int m, int[][] ans) {
        if(r < 0 || r >= n || c < 0 || c >= m || visited[r][c] == 1 || image[r][c] != initial)
        return;
        visited[r][c] = 1;
        ans[r][c] = colour;
        flood(ans, visited, r + 1, c, colour, initial, n, m, ans);
        flood(ans, visited, r - 1, c, colour, initial, n, m, ans);
        flood(ans, visited, r, c + 1, colour, initial, n, m, ans);
        flood(ans, visited, r, c - 1, colour, initial, n, m, ans);
    }
}