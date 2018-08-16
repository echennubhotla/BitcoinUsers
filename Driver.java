/*
Author: Esha Chennubhotla
In part 1 of Project 3, I get user input to get a source node and the minimum rating.
I read in the file and create new Users for each node in the file and add it to the
linkedlist ratings. I create a Graph that add for each user I add the edge to the other
Node to see what nodes the user is reachable to. I then call BFS, which is the
breadth-first-search algorithm that has an array called visited that is set to false
for each index and is set to true once the program reaches that node and set that node index
to true. It adds that index to the queue to see what nodes that is reachable to, and it
compares the ratings of each node to make sure it is greater than the minRating. I add the
nodes to an arraylist of source nodes that then uses Collections.sort to sort the source
nodes and print it.

In part 2 of Project 3, I created a recursive function in the Graph class, that recursively
finds all the paths from one user to another user. It starts with the currentUser to targetId
and checks each user in the adj[userId] linked list to see if any of the user are reachable
from there. It then adds each user to the pathList arraylist so we can then find the average
of all the users when the recursive function ends. It calculates the average of each path and
adds it to an arraylist of averages that then calculates the average in the Driver class by
calling a function called printAverage.

The driver method still asks from minimum acceptable rating in case you want to test for part 1
of Project 3, but the min rating is not used in part 2.

If you want to test part1 of the project, uncomment the printOutput function call on line 68.
When you run the program, it will only give you the output for part2 of project3.
 */

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;

    public class Driver {

        public static void main(String[] args) throws FileNotFoundException {
            String filename = args[0];
            File file = new File(filename);
            LinkedList<User> ratings = new LinkedList<User>();
            ArrayList<Integer> output = new ArrayList<Integer>();
            int size = 0;

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the user id: ");
            int currentUser = sc.nextInt();
            System.out.print("Enter the minimum acceptable rating: ");
            int minRating = sc.nextInt();
            System.out.print("Enter the target id: ");
            int targetUser = sc.nextInt();

            Scanner scan = new Scanner(file).useDelimiter(",|\\s+");
            int max = -1;
            while (scan.hasNext()) {
                int userId = scan.nextInt();
                int targetId = scan.nextInt();
                int rating = scan.nextInt();
                User u = new User(userId, targetId, rating);
                ratings.add(u);
                size++;
            }

            Graph gr = new Graph(size);


            for(User u: ratings){
                int sum = 0;
                gr.addEdge(u.getUserId(), u);
            }


            gr.BFS(currentUser, minRating, output);
            //printOutput(output);

            int rating = 0;

            User current = null;

            for(User u: ratings){
                if(u.getUserId() == currentUser){
                   current = u;
                }
            }

            ArrayList<Float> averages = new ArrayList<Float>();

            gr.findPaths(current,currentUser, targetUser, averages);
            printAverage(averages, currentUser, targetUser);


        }

        public static void printOutput(ArrayList<Integer> output){
            Collections.sort(output);
            for(int i = 0; i < output.size(); i++){
                System.out.println(output.get(i));
            }
        }

        public static void printAverage(ArrayList<Float> averages, int currentUser, int targetUser){
            float sum = 0;
            float avg = 0;

            if(averages.isEmpty()){
                System.out.println("No paths found");
            }
            else{
                for(float f: averages){
                    sum += f;
                }
                avg = sum/averages.size();
                System.out.println("Average ratings from " + currentUser + " to " + targetUser + " is: " + avg);
            }


        }


}
