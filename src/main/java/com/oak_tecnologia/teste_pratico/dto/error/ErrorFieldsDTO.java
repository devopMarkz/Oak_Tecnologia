package com.oak_tecnologia.teste_pratico.dto.error;

public class ErrorFieldsDTO {

    private String field;
    private String message;

    public ErrorFieldsDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
