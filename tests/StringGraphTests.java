import Graphs.DirectedGraph;
import Graphs.UndirectedGraph;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

    @Test
    public void StringUndirectedGraphPathDoesntExistReturnNull(){
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
        ug.addEdge("E","D");

        assertNull(ug.getPath("A","F"));
    }

    @Test
    public void StringDirectedGraphPathDoesntExistReturnNull(){
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
        dg.addEdge("E","D");

        assertNull(dg.getPath("A","F"));
    }

}
