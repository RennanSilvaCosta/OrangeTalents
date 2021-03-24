package com.orangetalents.desafio.service;

import com.orangetalents.desafio.entitys.User;
import com.orangetalents.desafio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    public boolean thisEmailExist(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    public boolean thisCpfExist(String cpf) {
        User user = userRepository.findByCpf(cpf);
        return user != null;
    }
}
