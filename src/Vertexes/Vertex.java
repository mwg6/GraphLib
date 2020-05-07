package Vertexes;

import java.util.HashSet;

public class Vertex implements IVertex {

    HashSet<IVertex> edges;

    public Vertex(){
        this.edges=new HashSet<>();
    }

    public Vertex(HashSet<IVertex> edges){
        this.edges=edges;
    }


    @Override
    public HashSet<IVertex> getEdges() {
        return edges;
    }

    @Override
    public void addEdge(IVertex v) {

        edges.add(v);

    }
}
