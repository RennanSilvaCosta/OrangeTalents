package com.orangetalents.desafio.service;

import com.orangetalents.desafio.dto.UserDTO;
import com.orangetalents.desafio.entitys.User;
import com.orangetalents.desafio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createNewUser(UserDTO dto) {
        thisEmailExist(dto.getEmail());
        thisCpfExist(dto.getCpf());
        User u = new User(dto);
        return new UserDTO(userRepository.save(u));
    }

    private void thisEmailExist(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent()) {
            //TODO: lancar exceção caso o email exista, pois o email deve ser unico.
            System.out.println("Email já existe");
        }
    }

    private void thisCpfExist(String cpf) {
        Optional<User> user = Optional.ofNullable(userRepository.findByCpf(cpf));
        if (user.isPresent()) {
            //TODO: lancar exceção caso o CPF exista, pois o CPF deve ser unico.
            System.out.println("CPF já existe");
        }
    }
}
