package com.eduardo.nasa.util;

import java.util.HashMap;
import java.util.Map;

public enum Direcao {

    NORTH("N", 0), SOUTH("S", 180), EAST("E", 90), WEST("W", 270);

    private final String orientacao;
    private final int graus;
    private static final Map<Integer, Direcao> mapaOrientacao = new HashMap<>();

    static {
        for (Direcao dir : Direcao.values()) {
            mapaOrientacao.put(dir.getGraus(), dir);
        }
    }

    Direcao(final String position, final int value) {
        this.orientacao = position;
        this.graus = value;
    }

    public String getOrientacao() {
        return this.orientacao;
    }

    public int getGraus() {
        return this.graus;
    }

    public static Direcao executarRotacao(Direcao direcao, Rotacionar rotacionar) {
        Direcao novaDirecao;

        int value = direcao.getGraus() + rotacionar.getNumRotacao();

        if (value < NORTH.getGraus()) {
            novaDirecao = WEST;
        } else if (value > WEST.getGraus()) {
            novaDirecao = NORTH;
        } else {
            novaDirecao = mapaOrientacao.get(value);
        }
        return novaDirecao;
    }
}
