package com.estudos.api_controle_ponto.exceptions;

// Classe para gerar erros personalizados
public class RegistroJaRealizadoException extends RuntimeException{
    public RegistroJaRealizadoException(String message) {
        super(message);
    }
}
