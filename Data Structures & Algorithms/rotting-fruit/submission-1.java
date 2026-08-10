class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int rf = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    rf++;
                }
            }
        }
        int[] delrow = {0,1,0,-1};
        int[] delcol = {1,0,-1,0};
        int l = 0;
        while (!q.isEmpty()) {
    int size = q.size();
    boolean rottedThisMinute = false;

    for (int i = 0; i < size; i++) {
        Pair top = q.poll();
        int r = top.first;
        int c = top.second;

        for (int k = 0; k < 4; k++) {
            int nr = r + delrow[k];
            int nc = c + delcol[k];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m
                    && grid[nr][nc] == 1) {
                grid[nr][nc] = 2;
                q.add(new Pair(nr, nc));
                rf--;
                rottedThisMinute = true;
            }
        }
    }

    if (rottedThisMinute) l++;
}

return rf == 0 ? l : -1;
    }
}
