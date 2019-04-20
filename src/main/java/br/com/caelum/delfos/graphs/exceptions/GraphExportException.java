package br.com.caelum.delfos.graphs.exceptions;

public class GraphExportException extends RuntimeException {

    public GraphExportException(String msg, Throwable e) {
        super(msg, e);
    }

    public GraphExportException(String msg) {
        super(msg);
    }

    public GraphExportException(Throwable cause) {
        super(cause);
    }

    public GraphExportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public GraphExportException() {}
}
