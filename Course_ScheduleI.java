import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_ScheduleI {
    class Solution {
    public void putStuff(Queue<Integer> queue,int[] inDeg){
        for(int i=0; i<inDeg.length; i++){
            if(inDeg[i]==0){queue.add(i);}
        }
    }
    public boolean solve(HashMap<Integer,List<Integer>> map,int[] inDeg,int numCourses){
        int[] visited = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        putStuff(queue,inDeg);
        // TC--> O(V+E) * LOGV
        // SC--> O(V)
        while(!queue.isEmpty()){
            int node = queue.poll(); // O(LOGV)
            visited[node] = 1;
            if(map.containsKey(node)){
                List<Integer> list = map.get(node);
                // O(V+E)
                for(int i=0; i<list.size(); i++){
                    int nde = list.get(i);
                    inDeg[nde]-=1;
                    if(inDeg[nde]==0){queue.add(nde);} // O(LOGV)
                }
            }
        }
        for(int i=0; i<visited.length; i++){
            if(visited[i]==0){return false;}
        }
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int[] inDeg = new int[numCourses]; //inDeg[i] will tell that how many nodes are dependent on the ith node
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            inDeg[v]+=1;
            if(map.containsKey(u)){
                List<Integer> list = map.get(u);
                list.add(v);
                map.put(u,list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(v);
                map.put(u,list);
            }
        }
        return solve(map,inDeg,numCourses);
    }
}
}
