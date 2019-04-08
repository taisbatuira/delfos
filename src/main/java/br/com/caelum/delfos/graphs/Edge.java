package br.com.caelum.delfos.graphs;

public class Edge {

    private Double weight;
    private Vertex from;
    private Vertex to;


    public Edge(Double weight, Vertex from, Vertex to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    public Double getWeight() {
        return weight;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }
}
