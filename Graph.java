import java.util.*;

public class Graph {

    private int vertices;
    private LinkedList<User> adj[];
    Queue<Integer> queue = new LinkedList<Integer>();

    public Graph(int v){
        vertices = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, User w){
        adj[v].add(w);
    }

    public void BFS(int v, int minRating, ArrayList<Integer> output){
        boolean visited[] = new boolean[vertices];
        visited[v] = true;
        queue.add(v);
        while(!queue.isEmpty()){
          v = queue.remove();
          Iterator<User> li = adj[v].iterator();
          while(li.hasNext()){
              User n = li.next();
              if (n.getRating() >= minRating && visited[n.getTargetId()] == false){
                  output.add(n.getTargetId());
                  visited[n.getTargetId()] = true;
                  queue.add(n.getTargetId());
              }
          }

        }
    }
    public void findPaths(User u,int userId, int targetId, ArrayList<Float> averages){
        boolean[] visited = new boolean[vertices];
        ArrayList<User>pathList = new ArrayList<User>();
        //pathList.add(u);
        float sum = 0;
        findAllPaths(userId, targetId, visited, pathList, sum, averages);
    }

    public void findAllPaths(int userId, int targetId, boolean[] visited, ArrayList<User>pathList, float sum, ArrayList<Float> averages){
        // int size = 0;
        visited[userId] = true;
        queue.add(userId);
        if(userId == targetId) {
            System.out.print("Average rating for path ");
            for (User i : pathList) {
                System.out.print(i.getUserId() + " ");
                sum += i.getRating();
            }
            float avg = sum/pathList.size();
            averages.add(avg);
            System.out.print(targetId + " is: " + avg);
            System.out.println();
        }
        for(User u : adj[userId]){
            if (visited[u.getTargetId()] == false){
                // size++;
                pathList.add(u);
                findAllPaths(u.getTargetId(), targetId, visited, pathList, sum, averages);
                pathList.remove(pathList.size()-1);
            }
        }
        queue.remove();
        visited[userId] = false;

    }


}
