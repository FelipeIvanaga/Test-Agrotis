package com.felipeivanaga.agrotis.exception;

public class LaboratorioNotFoundWithIdException extends NotFoundWithIdException {
    public LaboratorioNotFoundWithIdException(Long id) {
        super("Laboratorio com id: " + id + " não encontrado");
    }
}
