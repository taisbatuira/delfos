package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.ALTAdmissibleHeuristic;
import org.jgrapht.alg.shortestpath.AStarShortestPath;

import java.util.LinkedList;

public class AStarSearch<V, E> implements GraphSearch<V> {

    private final Graph<V, E> graph;

    public AStarSearch(Graph<V, E> graph) {
        this.graph = graph;
    }

    @Override
    public LinkedList<V> findPath(V from, V to) {

        AStarShortestPath<V, E> starShortestPath = new AStarShortestPath<>(graph.getGraphT(),
                new ALTAdmissibleHeuristic<>(graph.getGraphT(), graph.getVertexes()));

        GraphPath<V, E> path = starShortestPath.getPath(from, to);

        return new LinkedList<>(path.getVertexList());
    }

}
