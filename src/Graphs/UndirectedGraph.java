package Graphs;

import Vertexes.IVertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class UndirectedGraph implements IGraph {
    private Map<IVertex, HashSet<IVertex>> connections;

    @Override
    public boolean addVertex(IVertex v) {
        if(connections.containsKey(v)){
            return false;
        }
        else{
            connections.put(v, v.getEdges());
            for(IVertex a: v.getEdges()){
                a.addEdge(v);
            }
            return true;
        }
    }

    @Override
    public List<IVertex> getPath(IVertex v1, IVertex v2) {
        if(!connections.containsKey(v1)||!connections.containsKey(v2)){
            //can't path if either doesn't exist;
            return null;
        }

        return pathFinder(v1, v2, new HashSet<IVertex>(), new ArrayList<IVertex>());

    }

    private List<IVertex> pathFinder(IVertex v1, IVertex v2, HashSet<IVertex> visited, List<IVertex> path){
        if(v1.equals(v2)){
            path.add(v1);
            return path;
        }

        for(IVertex v : connections.get(v1)){
            if(!visited.contains(v1)){
                visited.add(v1);
                path.add(v1);
                pathFinder(v,v2,visited, path);
                path.remove(v1);
            }
        }
        return null;
    }

    @Override
    public boolean addEdge(IVertex v1, IVertex v2) {
        if(connections.containsKey(v1)&&connections.containsKey(v2)){
            //case both exist and just need unidirectional connection
            if(connections.get(v1).contains(v2)){
                //assumed behavior for connection already exists, return false.
                //cannot connect something doubly
                return false;
            }
            else{
                v1.addEdge(v2);
                v2.addEdge(v1);
                connections.put(v1, v1.getEdges());
                connections.put(v2, v2.getEdges());
                return true;
            }
        }
        //assumed behavior is both vertexes must be in the graph to be connected
        return false;
    }
}
