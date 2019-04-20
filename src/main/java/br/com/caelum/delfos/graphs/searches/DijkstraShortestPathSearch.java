package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.LinkedList;

public class DijkstraShortestPathSearch<V, E> implements GraphSearch<V> {

    private final Graph<V,E> graph;

    public DijkstraShortestPathSearch(Graph<V, E> graph) {
        this.graph = graph;
    }

    @Override
    public LinkedList<V> findPath(V from, V to) {
        GraphPath<V, E> path = DijkstraShortestPath.findPathBetween(graph.getGraphT(), from, to);

        return new LinkedList<>(path.getVertexList());
    }
}
