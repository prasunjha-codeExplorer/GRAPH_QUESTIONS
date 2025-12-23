import java.util.*;
class Solution {
    public void dfs(HashMap<Integer,List<Integer>> map,int[] visited,int node){
        if(map.containsKey(node)){
            List<Integer> l = map.get(node);
            for(int i=0; i<l.size(); i++){
                int nd = l.get(i);
                if(visited[nd]!=1){
                    visited[nd] = 1;
                    dfs(map,visited,nd);
                }
            }
        }
    }
    public int solve(HashMap<Integer,List<Integer>> map,int n){
        int[] visited = new int[n];
        int cntProvinces=0;
        for(int i=0; i<n; i++){
            if(visited[i]==0){
                cntProvinces++;
                visited[i] = 1;
                dfs(map,visited,i);
            }
        }
        return cntProvinces;
    }
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i!=j && isConnected[i][j]==1){
                    if(map.containsKey(i)){
                        List<Integer> l = map.get(i);
                        l.add(j);
                        map.put(i,l);
                    }else{
                        List<Integer> l = new ArrayList<>();
                        l.add(j);
                        map.put(i,l);
                    }
                }
            }
        }
        return solve(map,m);
    }
}