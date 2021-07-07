package com.orangetalents.desafio.controller;

import com.orangetalents.desafio.entitys.Vacina;
import com.orangetalents.desafio.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/vacinas")
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveVacina(@Valid @RequestBody Vacina vacina) {
        Vacina vac = vacinaService.createNewVacina(vacina);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(vacina.getId()).toUri();
        return ResponseEntity.created(uri).body(vacina);
    }
}
