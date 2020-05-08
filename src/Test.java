import Graphs.DirectedGraph;

import java.util.Arrays;

public class Test {

    public static void main(String... args){
        DirectedGraph dg = new DirectedGraph();

        dg.addVertex("A");
        dg.addVertex("B");
        dg.addVertex("C");
        dg.addVertex("D");
        dg.addVertex("E");
        dg.addVertex("F");

        dg.addEdge("A","B");
        dg.addEdge("A","C");
        dg.addEdge("A","D");
        dg.addEdge("D","A");
        dg.addEdge("D","E");
        dg.addEdge("E","B");

        if(dg.getPath("A","F")!=null){
            System.out.println(Arrays.toString(dg.getPath("A","F").toArray()));

        }




    }
}
