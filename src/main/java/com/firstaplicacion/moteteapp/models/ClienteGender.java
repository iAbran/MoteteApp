package com.firstaplicacion.moteteapp.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ClienteGender {
    MALE("Masculino"),
    FEMALE("Femenino"),
    OTHER("Otro");

    private final String genero;

    ClienteGender(String genero) {
        this.genero = genero;
    }

    @JsonValue
    public String getGenero() {
        return genero;
    }

    @JsonCreator
    public static ClienteGender fromString(String text) {
        for (ClienteGender g : ClienteGender.values()) {
            if (g.genero.equalsIgnoreCase(text)) {
                return g;
            }
        }
        throw new IllegalArgumentException("Unknow value: " + text);
    }

}
