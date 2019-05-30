package br.com.caelum.delfos.graphs.infra;

import br.com.caelum.delfos.graphs.DefaultGraph;
import br.com.caelum.delfos.graphs.WeightedGraph;
import br.com.caelum.delfos.graphs.mappers.OldCoursesToNewCousesMapper;
import br.com.caelum.delfos.graphs.mappers.Pair;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.*;

public class GraphFileReader extends FileReader {

    private final Scanner scanner;
    private OldCoursesToNewCousesMapper oldToNewMapper = new OldCoursesToNewCousesMapper();

    public GraphFileReader(String file) {
        super(file);
        scanner = super.getScanner();
    }

    public DefaultGraph readDefaultGraph() {
        Graph<Integer, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

        while(scanner.hasNext()) {
            String line = scanner.next();

            String[] destinations = extractDestinations(line);

            List<Pair> links = getLinks(destinations);
            for (Pair link : links) {
                Integer from = oldToNewMapper.getRelativeCourse(link.getFrom());
                Integer to = oldToNewMapper.getRelativeCourse(link.getTo());

                if(from.equals(to)) {
                    continue;
                }

                graph.addVertex(from);
                graph.addVertex(to);
                graph.addEdge(from, to);
            }
        }
        return new DefaultGraph(graph);
    }

    public WeightedGraph readWeightedGraph() {
        Graph<Integer, DefaultWeightedEdge> graph = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        while(scanner.hasNext()) {
            String line = scanner.next();

            String[] destinations = extractDestinations(line);

            List<Pair> links = getLinks(destinations);
            for (Pair link : links) {
                Integer from = oldToNewMapper.getRelativeCourse(link.getFrom());
                Integer to = oldToNewMapper.getRelativeCourse(link.getTo());

                if(from.equals(to)) {
                    continue;
                }

                graph.addVertex(from);
                graph.addVertex(to);
                DefaultWeightedEdge edge = graph.addEdge(from, to);

                if(edge == null) {
                    DefaultWeightedEdge e = graph.getEdge(from, to);

                    double weight = graph.getEdgeWeight(e) + 1.0;
                    graph.setEdgeWeight(e, weight);
                }
            }
        }
        return new WeightedGraph(graph);
    }

    private List<Pair> getLinks(String... destinations) {
        LinkedList<Pair> links = new LinkedList<>();

        for(int i = 0; i < destinations.length - 1; i++) {
            Integer from = Integer.parseInt(destinations[i]);
            Integer to = Integer.parseInt(destinations[i + 1]);

            Pair link = new Pair(from,to);
            links.add(link);
        }
        return links;
    }
}
