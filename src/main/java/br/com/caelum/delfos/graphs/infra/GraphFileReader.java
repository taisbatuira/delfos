package br.com.caelum.delfos.graphs.infra;


import br.com.caelum.delfos.graphs.DefaultGraph;
import br.com.caelum.delfos.graphs.WeightedGraph;
import br.com.caelum.delfos.graphs.mappers.OldCoursesToNewCousesMapper;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GraphFileReader {

    private final Scanner scanner;


    public GraphFileReader(String file) {
        Path path = Paths.get(file);
        try {
            scanner = new Scanner(path);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + path, e);
        }
        scanner.useDelimiter("(\\s)?](\n)?");
    }

    public DefaultGraph readDefaultGraph() {
        Graph<Integer, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

        while(scanner.hasNext()) {
            String line = scanner.next();

            String[] destinations = extractDestinations(line);

            List<Tuple2<Integer, Integer>> links = getLinks(destinations);
            for (Tuple2<Integer, Integer> link : links) {
                Integer from = OldCoursesToNewCousesMapper.getRelativeCourse(link._1);
                Integer to = OldCoursesToNewCousesMapper.getRelativeCourse(link._2);

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

            List<Tuple2<Integer, Integer>> links = getLinks(destinations);
            for (Tuple2<Integer, Integer> link : links) {
                Integer from = OldCoursesToNewCousesMapper.getRelativeCourse(link._1);
                Integer to = OldCoursesToNewCousesMapper.getRelativeCourse(link._2);

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

    private String[] extractDestinations(String line) {
        return line.replaceAll("(\\[\\s*|\\[\\d)|(\\n?])", "")
                .replaceAll("(\\s+)|(\\n\\s?)", " ")
                .replaceAll("\\s{2,}", " ")
                .split(" ");
    }

    private List<Tuple2<Integer, Integer>> getLinks(String... destinations) {
        LinkedList<Tuple2<Integer, Integer>> links = new LinkedList<>();

        for(int i = 0; i < destinations.length - 1; i++) {
            Integer to = Integer.parseInt(destinations[i]);
            Integer from = Integer.parseInt(destinations[i + 1]);

            Tuple2<Integer, Integer> link = Tuple.of(to, from);

            links.add(link);
        }

        return links;
    }
}
