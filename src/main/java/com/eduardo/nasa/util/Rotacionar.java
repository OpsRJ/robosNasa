package com.eduardo.nasa.util;

import java.util.HashMap;
import java.util.Map;

public enum Rotacionar {

    LEFT('L', -90), RIGHT('R', 90);

    private final char valorRotacao;
    private final int numRotacao;

    private static final Map<Character, Rotacionar> mapRotacao = new HashMap<>();

    static {
        for (Rotacionar rotationEnum : Rotacionar.values()) {
            mapRotacao.put(rotationEnum.getRotationValue(), rotationEnum);
        }
    }

    Rotacionar(char rotationValue, int value) {
        this.numRotacao = value;
        this.valorRotacao = rotationValue;
    }

    public int getNumRotacao() {
        return this.numRotacao;
    }

    public char getRotationValue() {
        return this.valorRotacao;
    }

    public static Rotacionar getValue(char rotation) {
        return mapRotacao.get(rotation);
    }
}
