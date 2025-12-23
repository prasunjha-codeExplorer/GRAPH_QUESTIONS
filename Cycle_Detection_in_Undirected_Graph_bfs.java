import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cycle_Detection_in_Undirected_Graph_bfs {
     // BFS APPROACH -->
       
       public boolean bfs(HashMap<Integer,List<Integer>> map,int[] visited,int node){
           Queue<Integer> queue = new LinkedList<>();
           queue.add(node);
           int[] parent = new int[visited.length];
           parent[node] = -1;
           visited[node] = 1;
           while(!queue.isEmpty()){
               int nd = queue.poll();
               //ITERATING ON THE EDGES FOR EACH NODE I
               if(map.containsKey(nd)){
                   List<Integer> list = map.get(nd);
                   for(int i=0; i<list.size(); i++){
                       int nxtNd = list.get(i);
                       parent[nxtNd] = nd;
                       if(visited[nxtNd]==1 && parent[nd]!=nxtNd){return true;}
                       else if(visited[nxtNd]!=1){queue.add(nxtNd);}
                       visited[nxtNd] = 1;
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
                if(bfs(map,visited,i)){return true;}
            }
        }
        return false;
    }
    
}
