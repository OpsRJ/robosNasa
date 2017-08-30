package com.eduardo.nasa.service;

import com.eduardo.nasa.exceptions.ComandoInvalidoException;
import com.eduardo.nasa.exceptions.MovimentarException;
import com.eduardo.nasa.model.Posicao;
import com.eduardo.nasa.util.Direcao;
import com.eduardo.nasa.util.Rotacionar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class MovimentarService {

    private Posicao p;

    public void initPosicaoSrv(Posicao p) {
        this.p = p;
    }

    public void moverPara() throws RuntimeException {
        int pX = this.p.getX();
        int pY = this.p.getY();
        Direcao dir = p.getDirecao();

        switch (dir) {
            case NORTH:
                pY++;
                break;
            case SOUTH:
                pY--;
                break;
            case EAST:
                pX++;
                break;
            case WEST:
                pY--;
                break;
        }

        if (isMovimentoValido(pX, pY)) {
            this.p.setX(pX);
            this.p.setY(pY);
        } else
            throw new MovimentarException("Erro ao se movimentar!");
    }

    public boolean isMovimentoValido(int pX, int pY) {
        return pX <= 4 && pX >= 0
                && pY >= 0 && pY <= 4;
    }

    private void executaRotacao(Rotacionar rotacionar) {
        Direcao direcao = this.p.getDirecao();

        Direcao novaDirecao = Direcao.executarRotacao(direcao, rotacionar);
        this.p.setDirecao(novaDirecao);
    }

    public Posicao mover(String comandos) throws RuntimeException {
        if (!isComandoValido(comandos))
            throw new ComandoInvalidoException("Comando Inválido!");

        for (char comando : comandos.toCharArray()) {
            if (isMoveInstruction(comando))
                moverPara();
            else if (isRotateInstruction(comando)) {
                Rotacionar rotacionar = Rotacionar.getValue(comando);
                executaRotacao(rotacionar);
            }
        }

        return this.p;
    }

    public boolean isComandoValido(String instructions) {
        boolean isValid = false;

        String limitacaoMovimentos = new String(new char[4 + 1]).replace("\0", String.valueOf('M'));

        if (!instructions.contains(limitacaoMovimentos) && instructions.matches("^[LRM]*"))
            isValid = true;

        return isValid;
    }

    public boolean isMoveInstruction(char comando) {
        return 'M' == comando;
    }

    public boolean isRotateInstruction(char comando) {
        return Rotacionar.getValue(comando) != null;
    }
}

