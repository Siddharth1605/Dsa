class Cell {
    int i;
    int j;
    int distance;
    public Cell(int i, int j, int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, -1, 0, 1};
        int n = heights.length;
        int m = heights[0].length;
        int[][] dis = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                dis[i][j] = Integer.MAX_VALUE;
        dis[0][0] = 0;
    
        queue.add(new Cell(0, 0, 0));

        while(!queue.isEmpty()) {
            Cell top = queue.poll();
            if(top.i == n-1 && top.j == m-1)
                return top.distance;
            for(int k=0;k<4;k++) {
                int i = top.i + di[k];
                int j = top.j + dj[k];
                if(i>=0 && i<n && j>=0 && j<m) {
                    int newEffort = Math.max(Math.abs(heights[i][j] - heights[top.i][top.j]), top.distance);
                    if(dis[i][j] > newEffort) {
                        dis[i][j] = newEffort;
                        queue.add(new Cell(i, j, newEffort));
                    }
                }
            }
        }
        return 0;
    }
}