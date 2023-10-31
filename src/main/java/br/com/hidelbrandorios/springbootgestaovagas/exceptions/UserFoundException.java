package br.com.hidelbrandorios.springbootgestaovagas.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuario já existe");
    }

}
