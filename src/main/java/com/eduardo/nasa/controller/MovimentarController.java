package com.eduardo.nasa.controller;

import com.eduardo.nasa.model.Posicao;
import com.eduardo.nasa.service.MovimentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/mars/")
public class MovimentarController {

    @Autowired
    MovimentarService srv;

    @RequestMapping(method= RequestMethod.POST, path="/mover",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> mover(@RequestParam("comando") String comando) {
        Posicao p = new Posicao();
        srv.initPosicaoSrv(p);

        return new ResponseEntity(srv.mover(comando), HttpStatus.OK);
    }
}
