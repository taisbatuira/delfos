package br.com.caelum.delfos.graphs.exceptions;

public class GraphException extends RuntimeException {

    public GraphException(String msg) {
        super(msg);
    }

    public GraphException(String msg, Exception e) {
        super(msg, e);
    }
}
