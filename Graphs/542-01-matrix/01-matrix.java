class Triplet {
    int i;
    int j;
    int dis;
    public Triplet(int i, int j, int dis) {
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
}
class Solution {
    public void bfs(int si, int sj, int[][] vis, int[][] sln, int[][] mat) {
        Queue<Triplet> queue = new LinkedList<>();
        queue.add(new Triplet(si, sj, 0));
        vis[si][sj] = 1;
        int[] di = {0, -1, 1, 0};
        int[] dj = {-1, 0, 0, 1};
        while(!queue.isEmpty()) {
            Triplet top = queue.poll();
            sln[top.i][top.j]  = top.dis;
            for(int i=0;i<4;i++) {
                int nexti = top.i + di[i];
                int nextj = top.j + dj[i];
                if(nexti < 0 || nexti >= mat.length || nextj < 0 || nextj >= mat[0].length || vis[nexti][nextj] == 1 || mat[nexti][nextj] == 0)
                continue;
                vis[nexti][nextj] = 1;
                queue.add(new Triplet(nexti, nextj, top.dis + 1));
            }
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] sln = new int[n][m];
        int[][] vis = new int[n][m];

        
        Queue<Triplet> queue = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[i][j] == 0) 
                {
                    queue.add(new Triplet(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] di = {0, -1, 1, 0};
        int[] dj = {-1, 0, 0, 1};
        while(!queue.isEmpty()) {
            Triplet top = queue.poll();
            sln[top.i][top.j]  = top.dis;
            for(int i=0;i<4;i++) {
                int nexti = top.i + di[i];
                int nextj = top.j + dj[i];
                if(nexti < 0 || nexti >= mat.length || nextj < 0 || nextj >= mat[0].length || vis[nexti][nextj] == 1 || mat[nexti][nextj] == 0)
                continue;
                vis[nexti][nextj] = 1;
                queue.add(new Triplet(nexti, nextj, top.dis + 1));
            }
        }
        return sln;
    }
}