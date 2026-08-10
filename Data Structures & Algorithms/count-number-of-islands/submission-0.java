class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void solve(int i, int j, char[][] grid, int[][] vis, int n, int m){
        vis[i][j]=1;
        int[] delrow = {0,1,0,-1};
        int[] delcol = {1,0,-1,0};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            Pair top = q.poll();
            int r = top.first;
            int c = top.second;

            for(int k=0; k<4; k++){
                int nr = r + delrow[k];
                int nc = c + delcol[k];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]=='1'){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc] = 1;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int ans = 0 ;

        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    ans++;
                    solve(i,j,grid,vis,n,m);
                }
            }
        }
        return ans;
    }
}
