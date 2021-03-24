package com.orangetalents.desafio.service;

import com.orangetalents.desafio.entitys.User;
import com.orangetalents.desafio.entitys.Vacina;
import com.orangetalents.desafio.repository.UserRepository;
import com.orangetalents.desafio.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private UserRepository userRepository;

    public Vacina createNewVacina(Vacina vacina) {
        return vacinaRepository.save(vacina);
    }

    public boolean validateUser(Vacina vacina) {
        User u = userRepository.findByEmail(vacina.getEmailUser());
        return u != null;
    }

}
