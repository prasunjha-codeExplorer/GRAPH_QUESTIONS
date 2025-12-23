import java.util.HashMap;
import java.util.List;

public class Cycle_Detection_in_undirected_Graph_dfs {
    // DFS APPROACH -->
      
    public boolean dfs(HashMap<Integer,List<Integer>> map,int[] visited,int node,int parent){
        visited[node] = 1;
        if(map.containsKey(node)){
            List<Integer> list = map.get(node);
            //ITERATING ON THE EDGES !!
            for(int i=0; i<list.size(); i++){
                int nd = list.get(i);
                if(visited[nd]==1 && nd!=parent){return true;}
                else if(visited[nd]!=1){
                    if(dfs(map,visited,nd,node)){return true;}
                }
            }
        }
        return false;
    } 
    public boolean solve(HashMap<Integer,List<Integer>> map,int v){
        int[] visited = new int[v];
        //For multiple components
        for(int i=0; i<v; i++){
            if(visited[i]==0){
                if(dfs(map,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
}
