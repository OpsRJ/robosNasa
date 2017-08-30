package com.eduardo.nasa.service;

import com.eduardo.nasa.exceptions.ComandoInvalidoException;
import com.eduardo.nasa.exceptions.MovimentarException;
import com.eduardo.nasa.model.Posicao;
import org.junit.Test;

public class ServiceTeste {

    MovimentarService srv = new MovimentarService();

    public void moverSemErro() {
        Posicao p = new Posicao();
        srv.initPosicaoSrv(p);
        srv.mover("MMMMR");

        Posicao p2 = new Posicao();
        srv.initPosicaoSrv(p);
        srv.mover("MRLML");

        Posicao p3 = new Posicao();
        srv.initPosicaoSrv(p3);
        srv.mover("MRMMRML");
    }

    @Test(expected = ComandoInvalidoException.class)
    public void comadoInvalidoError() {
        Posicao p = new Posicao();
        srv.initPosicaoSrv(p);
        srv.mover("AB059MLR");
    }

    @Test(expected = MovimentarException.class)
    public void movimentoInvalidoError() {
        Posicao p = new Posicao();
        srv.initPosicaoSrv(p);
        srv.mover("MMLMRMMRMMRMMMM");
    }
}
