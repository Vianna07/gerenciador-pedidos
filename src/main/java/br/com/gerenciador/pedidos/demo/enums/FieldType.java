package br.com.gerenciador.pedidos.demo.enums;

import lombok.Getter;

@Getter
public enum FieldType {
    TEXT("text"),
    INT("int"),
    FLOAT("flaot"),
    SELECT("select");

    public final String value;

    FieldType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
