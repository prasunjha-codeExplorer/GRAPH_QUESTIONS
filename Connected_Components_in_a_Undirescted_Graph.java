import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Connected_Components_in_a_Undirescted_Graph {
    class Solution {
    public void dfs(HashMap<Integer,ArrayList<Integer>> map,int[] visited,ArrayList<Integer> ans,int node){
        ans.add(node);
        if(map.containsKey(node)){
        ArrayList<Integer> l = map.get(node);
        // Traversing on Edges
        for(int i=0; i<l.size(); i++){
            int nd = l.get(i);
            if(visited[nd]!=1){
                visited[nd] = 1;
                dfs(map,visited,ans,nd);
            }
        }
        }
    }
    public void bfs(HashMap<Integer,ArrayList<Integer>> map,int[] visited,ArrayList<ArrayList<Integer>> list,int node){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(node);
        while(!queue.isEmpty()){
                int nd = queue.poll();
                ans.add(nd);
                if(map.containsKey(nd)){
                    List<Integer> l = map.get(nd);
                    // Traversing on Edges
                    for(int j=0; j<l.size(); j++){
                        int nde = l.get(j);
                        if(visited[nde]!=1){
                            visited[nde] = 1;
                            queue.add(nde);
                        }
                    }
             }
        }
        list.add(ans);
    }
    public ArrayList<ArrayList<Integer>> solve(HashMap<Integer,ArrayList<Integer>> map,int v){
        int[] visited = new int[v];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<v; i++){
            if(visited[i]==0){
                visited[i] = 1;
                bfs(map,visited,list,i);
                // ArrayList<Integer> ans = new ArrayList<>();
                // dfs(map,visited,ans,i);
                // list.add(ans);
            }
        }
        return list;
    }
    public ArrayList<ArrayList<Integer>> getComponents(int v, int[][] edges) {
        // code here
        int n = edges.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            ArrayList<Integer> l = new ArrayList<>();
            if(map.containsKey(a)){
                l = map.get(a);
                l.add(b);
                map.put(a,l);
            }else{
                l.add(b);
                map.put(a,l);
            }
            if(map.containsKey(b)){
                l = map.get(b);
                l.add(a);
                map.put(b,l);
            }else{
                l.add(a);
                map.put(b,l);
            }
        }
        return solve(map,v);
    }
}
}
