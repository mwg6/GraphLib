import Graphs.DirectedGraph;
import Graphs.ThreadSafeDirectedGraph;
import Graphs.UndirectedGraph;

import java.util.Arrays;

public class main {

    public static void main(String... args){
        String v1 = "A";
        String v2 = "B";
        String v3 = "C";
        String v4 = "D";
        String v5 = "E";
        String v6 = "F";

        ThreadSafeDirectedGraph dg = new ThreadSafeDirectedGraph();

        dg.addVertex(v1);
        dg.addVertex(v2);
        dg.addVertex(v3);
        dg.addVertex(v4);
        dg.addVertex(v5);
        dg.addVertex(v6);

        dg.addEdge(v1,v2);
        dg.addEdge(v1,v3);
        dg.addEdge(v1,v4);
        dg.addEdge(v4,v1);
        dg.addEdge(v4,v5);
        dg.addEdge(v5,v6);




        if(dg.getPath(v1,v6)!=null){
            System.out.println(Arrays.toString(dg.getPath(v1,v6).toArray()));

        }




    }
}
