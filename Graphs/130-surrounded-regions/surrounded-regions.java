class Solution {
    public void dfs(int i, int j, char[][] board, int[][] vis) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || vis[i][j] == 1 || board[i][j] == 'X')
            return;
        vis[i][j] = 1;
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, -1, 0, 1};

        for(int k=0;k<4;k++) {
            dfs(i + di[k], j + dj[k], board, vis);
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        for(int j=0;j<m;j++)
        {
            dfs(0, j, board, vis);
            dfs(n-1, j, board, vis);
        }

        for(int i=0;i<n;i++) {
            dfs(i, 0, board, vis);
            dfs(i, m-1, board, vis);
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j] == 'O' && vis[i][j] == 0) 
                    board[i][j] = 'X';
            }
        }
    }
}