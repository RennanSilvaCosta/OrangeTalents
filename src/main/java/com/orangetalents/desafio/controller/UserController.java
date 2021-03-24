package com.orangetalents.desafio.controller;

import com.orangetalents.desafio.entitys.User;
import com.orangetalents.desafio.service.UserService;
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
@RequestMapping(value = "/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user) {
        if (userService.thisEmailExist(user.getEmail())) {
            return ResponseEntity.badRequest().build();
        } else {
            if (userService.thisCpfExist(user.getCpf())) {
                return ResponseEntity.badRequest().build();
            } else {
                User usuario = userService.createNewUser(user);
                URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(usuario.getId()).toUri();
                return ResponseEntity.created(uri).body(usuario);
            }
        }
    }

}
