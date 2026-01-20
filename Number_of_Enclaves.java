public class Number_of_Enclaves {
    class Solution {
    // TC --> O(M*N)
    // SC --> O(M*N)
    public void fillWithDiffVal(int[][] grid,int r,int c){
        int m = grid.length;
        int n = grid[0].length;
        grid[r][c] = 2;
        //Right
        if(c<n-1 && grid[r][c+1]==1){
            fillWithDiffVal(grid,r,c+1);
        }
        //Left
        if(c>0 && grid[r][c-1]==1){
            fillWithDiffVal(grid,r,c-1);
        }
        //Up
        if(r>0 && grid[r-1][c]==1){
            fillWithDiffVal(grid,r-1,c);
        }
        //Down
        if(r<m-1 && grid[r+1][c]==1){
            fillWithDiffVal(grid,r+1,c);
        }
    }
    public int solve(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int cnt=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //Mark all the out side boundaries first
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && grid[i][j]==1){
                    fillWithDiffVal(grid,i,j);
                }
            }
        }
        return solve(grid);
    }
}
}
