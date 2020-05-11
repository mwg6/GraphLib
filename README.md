# GraphLib
Library for extensible graphs (directed and undirected)

Expected behavior for this library is to instantiate the implementation of IGraph
that you wish to use (DirectedGraph or UndirectedGraph).

Then add your user-defined Vertexes.

Finally, indicate which vertexes should be connected by edges.

Calling getPath will return a path between any two Vertexes if it exists, and null
otherwise.

