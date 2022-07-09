package com.felipeivanaga.agrotis.exception;

public class PropriedadeNotFoundWithIdException extends NotFoundWithIdException {
    public PropriedadeNotFoundWithIdException(Long id) {
        super("Propriedade com id: " + id + " não encontrada");
    }
}
