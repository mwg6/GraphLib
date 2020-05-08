import Graphs.DirectedGraph;
import Graphs.UndirectedGraph;

import java.util.Arrays;

public class Test {

    public static void main(String... args){
        UndirectedGraph dg = new UndirectedGraph();

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
        dg.addEdge("E","F");

        if(dg.getPath("A","F")!=null){
            System.out.println(Arrays.toString(dg.getPath("A","F").toArray()));

        }




    }
}
