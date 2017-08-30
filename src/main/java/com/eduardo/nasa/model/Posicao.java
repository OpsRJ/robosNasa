package com.eduardo.nasa.model;

import com.eduardo.nasa.util.Direcao;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Posicao {

    @JsonIgnore
    private int x;

    @JsonIgnore
    private int y;

    @JsonIgnore
    private Direcao direcao;

    private String resultado;

    public Posicao() {
        this.x = 0;
        this.y = 0;
        this.direcao = Direcao.NORTH;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }

    public String getResultado() {
        return toString();
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y +", " + direcao.getOrientacao() + ")";
    }
}
