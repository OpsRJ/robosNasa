package com.eduardo.nasa.model;

import org.springframework.http.HttpStatus;

public class ErroMsg {

    private String msgErro;
    private int status;

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
