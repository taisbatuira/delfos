package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.Graph;
import br.com.caelum.delfos.graphs.exceptions.GraphException;
import org.jgrapht.traverse.BreadthFirstIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

public class BreadthFirstSearch<V, E> implements GraphSearch<V> {


    private final Graph<V, E> graph;
    private final LinkedList<V> path = new LinkedList<>();

    public BreadthFirstSearch(Graph<V, E> graph) {
        this.graph = graph;
    }

    @Override
    public LinkedList<V> findPath(V from, V to) {


        Optional<V> vertex = graph.getVertex(from);

        if(!vertex.isPresent()) {
            throw new GraphException("Vertex not present in graph");
        }

        V start = vertex.get();

        Iterator<V> search = new BreadthFirstIterator<>(graph.getGraphT(), start);
        while (search.hasNext()) {
            V v = search.next();
            path.add(v);
            if (v.equals(to)) break;
        }

        return path;
    }

}
