package naeli.primeirojava.api.exceptionhandler;

import naeli.primeirojava.controller.NegocioException;

public class EntidadeNaoEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }

}