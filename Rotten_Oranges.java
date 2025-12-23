import java.util.LinkedList;
import java.util.Queue;

public class Rotten_Oranges {
    class iPairs{
    int f;
    int s;
    public iPairs(int f,int s){
        this.f=f;
        this.s=s;
    }
}
class Solution {
    public int isRotten(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){return -1;}
            }
        }
        return 0;
    }
    public void check(int[][] grid,Queue<iPairs> queue){
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    queue.add(new iPairs(i,j));
                }
            }
        }
    }
    public int solve(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        Queue<iPairs> queue = new LinkedList<>();
        int[] row = {-1,1,0,0};
        int[] col = {0,0,-1,1};
        check(grid,queue);
        int cnt=0;
        while(!queue.isEmpty()){
            int len = queue.size();
            int ct=0;
            for(int i=0; i<len; i++){
                iPairs p = queue.poll();
                int r = p.f;
                int c = p.s;
                for(int j=0; j<4; j++){
                    int r1 = r - row[j];
                    int r2 = c - col[j];
                    if(r1>=0 && r2>=0 && r1<m && r2<n){
                        if(grid[r1][r2]==1){
                            if(ct==0){ct++;}
                            queue.add(new iPairs(r1,r2));
                            grid[r1][r2] = 2;
                        }
                    }
                }
            }
            cnt+=ct;
        }
        int ans = isRotten(grid);
        return ans==0 ? cnt : -1;
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return solve(grid);
    }
}
}
