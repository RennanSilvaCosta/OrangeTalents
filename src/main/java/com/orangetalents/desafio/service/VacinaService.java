package com.orangetalents.desafio.service;

import com.orangetalents.desafio.dto.UserDTO;
import com.orangetalents.desafio.dto.VacinaDTO;
import com.orangetalents.desafio.dto.VacinaInsertDTO;
import com.orangetalents.desafio.entitys.User;
import com.orangetalents.desafio.entitys.Vacina;
import com.orangetalents.desafio.repository.UserRepository;
import com.orangetalents.desafio.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private UserRepository userRepository;

    public VacinaDTO createNewVacina(VacinaInsertDTO vacinaInsertDTO) {
        VacinaDTO vacinaDTO = validateUser(vacinaInsertDTO);
        vacinaDTO.setNomeVacina(vacinaInsertDTO.getNomeVacina());
        vacinaDTO.setDataAplicacao(vacinaInsertDTO.getDataAplicacao());
        Vacina vacina = new Vacina(vacinaDTO);
        return new VacinaDTO(vacinaRepository.save(vacina));
    }

    private VacinaDTO validateUser(VacinaInsertDTO vacina) {
        Optional<User> user = userRepository.findById(vacina.getIdUser());
        if (user.isPresent()) {
            VacinaDTO vac = new VacinaDTO();
            UserDTO u = new UserDTO(user.get());
            vac.setUserDTO(u);
            return vac;
        } else {
            //TODO: lançar exceção, pois o usuario não foi encontrado
            System.out.println("Usuario não existe");
            return null;
        }
    }

}
