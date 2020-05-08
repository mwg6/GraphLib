package Graphs;

import java.util.List;

interface IGraph{

    public boolean addVertex(Object v);
    public boolean addEdge(Object v1, Object v2);
    public List<Object> getPath(Object v1, Object v2);

}