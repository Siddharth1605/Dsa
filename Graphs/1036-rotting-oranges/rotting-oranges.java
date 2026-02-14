class Triplet {
    int i;
    int j;
    int t;
    public Triplet(int i, int j, int t) {
        this.i = i;
        this.j = j;
        this.t = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] conv = new int[n][m];
        Queue<Triplet> queue = new LinkedList<>();
        int c = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2) {
                    queue.add(new Triplet(i, j, 0));
                    c++;
                }
            }
        }
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};

        int time = 0;
        while(!queue.isEmpty()) {
            Triplet top = queue.remove();
            int prow = top.i;
            int pcol = top.j;
            time = Math.max(time, top.t);

            for(int i=0;i<4;i++) {
                int crow = prow + drow[i];
                int ccol = pcol + dcol[i];

                if(crow<0 || crow>=n || ccol <0 || ccol >=m || grid[crow][ccol] != 1)
                continue;
                queue.add(new Triplet(crow, ccol, top.t + 1));
                grid[crow][ccol] = 2;
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1 && conv[i][j] == 0)
                    return -1;
            }
        }

        return time;
    }
}