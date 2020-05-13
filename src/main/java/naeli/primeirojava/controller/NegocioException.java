package naeli.primeirojava.controller;

public class NegocioException extends RuntimeException {

    private static final long serialVarsionUID = 1L;

    public NegocioException(String message) {
        super(message);
    }

}