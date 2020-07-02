import java.util.LinkedList;
import java.util.*;


public class Map {

    private int nodes; // represents city inputs

    private LinkedList<Integer> adj[]; // Adjacent list of cities

    Map(int n) // creates n(cities) to input in a coordinate
    {
        //my input is 100 creating a coordinate point of 100 by 100
        nodes = n;

        adj = new LinkedList[n];

        for(int a = 0; a < n; ++a){
            adj[a] = new LinkedList();
        }
    }

    //Distance function
    //creates distance between to newly inputed cities
    void addDistance(int x, int y){
        try {
            adj[x].add(y);
        }catch (IndexOutOfBoundsException out){
            out.printStackTrace();
        }
    }


    //Calculated distance using math function from node to node
    //calculating distance plots on the graph point x to y
    double calculateDistance(int x, int y){
        return Math.sqrt(Math.pow(x-0,2) + Math.pow(y-0,2) * 1.0);

    }

    //Does the path exist based on the number of nodes input
    //if out of bound path does not exists
    //example 102 by 102
    Boolean reachable(int p, int q){
        boolean marked[] = new boolean[nodes];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        marked[p] = true;
        queue.add(p);

        Iterator<Integer> a;
         while(queue.size() != 0)
         {
             p = queue.poll();

             int b;
             a = adj[p].listIterator();


             while(a.hasNext()){
                 b = a.next();

                 if(b == q){
                     return true;
                 }
                 if(!marked[b]){
                     marked[b] = true;
                     queue.add(b);
                 }
             }

         }

         return false;

    }
    public static void main(String[]args){
        Scanner input = new Scanner((System.in));
        int n = 100;
        Map m = new Map(n); // produce a coordinate of 100 by 100
        for(int a = 0; a < n; a++){
            for(int b = 0; b < n; b++){
                m.addDistance(a,b);
            }
        }


        //User can enter coordinates as character and it will be converted to an Integer
        //conversion is a whole number to hexadecimal output
        char xdata = 'a';
        char ydata = 'b';
        int cityDistance = 5;

        System.out.println("Enter the following coordinate point");
        System.out.println("Enter for X");
        xdata = input.next().charAt(0);
        System.out.println("Enter for Y");
        ydata = input.next().charAt(0);
        System.out.println("Enter Cities distance");
        cityDistance = input.nextInt();
        System.out.println("You have entered th following input " + xdata + "," + ydata + "  " + cityDistance);
        int x = Character.getNumericValue(xdata);
        int y = Character.getNumericValue(ydata);
        double distance = m.calculateDistance(x,y);
        System.out.println("The output is " + Math.round(distance));

        try {
            if (m.reachable(x, y)) {
                System.out.println("City Paths " + x + " to " + y + " exists");
            } else {
                System.out.println("City Paths from" + x + " to " + y + "does not exist");
            }
        }catch (IndexOutOfBoundsException o){
         o.printStackTrace();
        }





    }
}
//sources
// functions addDistance and Map constructor setup derived and modified from Aakash Hasija
//https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/
