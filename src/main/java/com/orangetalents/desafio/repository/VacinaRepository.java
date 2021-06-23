package com.orangetalents.desafio.repository;

import com.orangetalents.desafio.entitys.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {

}
