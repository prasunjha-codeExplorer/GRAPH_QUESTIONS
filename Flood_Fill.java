import java.util.LinkedList;
import java.util.Queue;

public class Flood_Fill {
    class iPairs{
    int f;
    int s;
    public iPairs(int f,int s){
        this.f=f;
        this.s=s;
    }
}
class Solution {
    public int[][] solve(int[][] image,int sr,int sc,int color){
        int[] row = {-1,1,0,0};
        int[] col = {0,0,-1,1};
        int m = image.length;
        int n = image[0].length;
        int[][] visited = new int[m][n];
        visited[sr][sc] = 1;
        Queue<iPairs> queue = new LinkedList<>();
        queue.add(new iPairs(sr,sc));
        while(!queue.isEmpty()){
                iPairs p = queue.poll();
                int r = p.f;
                int c = p.s;
                for(int j=0; j<4; j++){
                    int r1 = r - row[j];
                    int r2 = c - col[j];
                    if(r1>=0 &&  r2>=0 && r1<m && r2<n){
                        if(image[r][c] == image[r1][r2] && visited[r1][r2]!=1){
                           queue.add(new iPairs(r1,r2));
                           visited[r1][r2] = 1;
                        }
                    }
                }
                image[r][c] = color;
        }
        return image;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        return solve(image,sr,sc,color);
    }
}
}
