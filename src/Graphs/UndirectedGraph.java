package Graphs;

import java.util.*;

public class UndirectedGraph implements IGraph {
    private Map<Object, HashSet<Object>> connections;

    public UndirectedGraph(){
        connections = new HashMap<>();
    }

    @Override
    public boolean addVertex(Object v) {
        if(connections.containsKey(v)){
            return false;
        }
        else{
            connections.put(v, new HashSet<>());
            return true;
        }
    }

    @Override
    public List<Object> getPath(Object v1, Object v2) {
        if(!connections.containsKey(v1)||!connections.containsKey(v2)){
            //can't path if either doesn't exist;
            return null;
        }

        return pathFinder(v1, v2, new HashSet<Object>(), new ArrayList<Object>());

    }

    private List<Object> pathFinder(Object v1, Object v2, HashSet<Object> visited, List<Object> path){
        if(v1.equals(v2)){
            path.add(v1);
            return path;
        }

        for(Object v : connections.get(v1)){
            if(!visited.contains(v)){
                visited.add(v1);
                path.add(v1);
                //clunky
                List<Object> tmp = pathFinder(v,v2,visited, path);
                if(tmp!=null){
                    return tmp;
                }

                path.remove(v1);
            }
        }
        return null;
    }

    @Override
    public boolean addEdge(Object v1, Object v2) {
        if(connections.containsKey(v1)&&connections.containsKey(v2)){
            //case both exist and just need unidirectional connection
            if(connections.get(v1).contains(v2)){
                //assumed behavior for connection already exists, return false.
                //cannot connect something doubly
                return false;
            }
            else{
                HashSet<Object> tmp1 = connections.get(v1);
                HashSet<Object> tmp2 = connections.get(v2);
                tmp1.add(v2);
                tmp2.add(v1);

                connections.put(v1, tmp1);
                connections.put(v2, tmp2);
                return true;
            }
        }
        //assumed behavior is both vertexes must be in the graph to be connected
        return false;
    }
}
