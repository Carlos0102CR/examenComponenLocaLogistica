package com.cenfotec.localogistica.repository;

import com.cenfotec.localogistica.domain.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaqueteRepository extends JpaRepository<Paquete,Long> {
    List<Paquete> findAllByVueloDestino(String vuelo);
    List<Paquete> findAllByNumCuentaCosignatario(Long id);
}
