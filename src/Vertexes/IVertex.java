package Vertexes;

import java.util.HashSet;

public interface IVertex {
    public HashSet<IVertex> getEdges();
    public void addEdge(IVertex v);
}
