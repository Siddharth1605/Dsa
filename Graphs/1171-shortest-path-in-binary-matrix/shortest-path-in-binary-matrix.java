class Grid {
    int i;
    int j;
    int distance;
    public Grid(int i, int j, int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        int n = grid.length;
        Queue<Grid> queue = new LinkedList<>();
        int[][] dis = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dis[i][j] = Integer.MAX_VALUE;
        dis[0][0] = 1;
        queue.add(new Grid(0, 0, 1));
        int[] di = {-1, 0, 1, 0, -1, 1, -1, 1};
        int[] dj = {0, -1, 0, 1, -1, 1, 1, -1};
        while(!queue.isEmpty()) {
            Grid node = queue.poll();

            for(int k=0;k<8;k++) {
                int adjI = node.i + di[k];
                int adjJ = node.j + dj[k];
                if(adjI >=0 && adjI < n && adjJ >= 0 && adjJ < n && grid[adjI][adjJ] == 0 && dis[adjI][adjJ] > node.distance + 1) {
                    dis[adjI][adjJ] = node.distance + 1;
                    if(adjI == n-1 && adjJ == n-1)
                        return dis[adjI][adjJ];
                    queue.add(new Grid(adjI, adjJ, dis[adjI][adjJ]));
                }
                
            }
        }
        return dis[n-1][n-1] == Integer.MAX_VALUE ? -1 : dis[n-1][n-1];
    }
}