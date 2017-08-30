package com.eduardo.nasa.controller;

import com.eduardo.nasa.model.Posicao;
import com.eduardo.nasa.service.MovimentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/mars/")
public class MovimentarController {

    @Autowired
    MovimentarService srv;

    @RequestMapping(method= RequestMethod.POST, path="/mover",  produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String mover(@RequestParam("comando") String comando) {
        Posicao p = new Posicao();
        srv.initPosicaoSrv(p);
        Posicao posicao = srv.mover(comando);

        return posicao.getResultado();
        //return new ResponseEntity(srv.mover(comando), HttpStatus.OK);
    }
}
