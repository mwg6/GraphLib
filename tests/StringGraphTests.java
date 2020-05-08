import Graphs.DirectedGraph;
import Graphs.ThreadSafeDirectedGraph;
import Graphs.UndirectedGraph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class StringGraphTests {

    @Test
    public void StringsDirectedGraphPathExists(){
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
        dg.addEdge("E","F");

        assertEquals("[A, D, E, F]",Arrays.toString(dg.getPath("A","F").toArray()));
        assertEquals("[A, D]",Arrays.toString(dg.getPath("A","D").toArray()));
        assertEquals("[D, E, F]",Arrays.toString(dg.getPath("D","F").toArray()));

    }

    @Test
    public void StringsUndirectedGraphPathExists(){
        UndirectedGraph ug = new UndirectedGraph();

        ug.addVertex("A");
        ug.addVertex("B");
        ug.addVertex("C");
        ug.addVertex("D");
        ug.addVertex("E");
        ug.addVertex("F");

        ug.addEdge("A","B");
        ug.addEdge("A","C");
        ug.addEdge("A","D");
        ug.addEdge("D","A");
        ug.addEdge("D","E");
        ug.addEdge("E","F");

        assertEquals("[A, D, E, F]",Arrays.toString(ug.getPath("A","F").toArray()));
        assertEquals("[A, D]",Arrays.toString(ug.getPath("A","D").toArray()));
        assertEquals("[D, E, F]",Arrays.toString(ug.getPath("D","F").toArray()));
        assertEquals("[F, E, D, A]",Arrays.toString(ug.getPath("F","A").toArray()));

    }

}
