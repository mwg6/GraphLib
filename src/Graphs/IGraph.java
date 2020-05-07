package Graphs;

import Vertexes.IVertex;

import java.util.List;

interface IGraph{

    public boolean addVertex(IVertex v);
    public boolean addEdge(IVertex v1, IVertex v2);
    public List<IVertex> getPath(IVertex v1, IVertex v2);

}