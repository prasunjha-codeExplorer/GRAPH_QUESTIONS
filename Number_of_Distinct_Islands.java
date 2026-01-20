import java.util.HashSet;

public class Number_of_Distinct_Islands {
    // User function Template for Java

class Solution {
    public void dfs(int[][] grid,int r,int c,String[] s){
        int m = grid.length;
        int n = grid[0].length;
        
        grid[r][c] = 2;
        // Right
        if(c<n-1 && grid[r][c+1]==1){
            s[0]+="R";
            dfs(grid,r,c+1,s);
        }
        // Left
        if(c>0 && grid[r][c-1]==1){
            s[0]+="L";
            dfs(grid,r,c-1,s);
        }
        // Up
        if(r>0 && grid[r-1][c]==1){
            s[0]+="U";
            dfs(grid,r-1,c,s);
        }
        // Down
        if(r<m-1 && grid[r+1][c]==1){
            s[0]+="D";
            dfs(grid,r+1,c,s);
        }
        s[0]+="T";
    }
    public int solve(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    String[] s = {""};
                    dfs(grid,i,j,s);
                    set.add(s[0]);
                }
            }
        }
        return set.size();
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m = grid.length;
        int n = grid[0].length;
        return solve(grid);
    }
}

}
