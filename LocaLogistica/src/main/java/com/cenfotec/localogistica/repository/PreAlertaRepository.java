package com.cenfotec.localogistica.repository;

import com.cenfotec.localogistica.domain.PreAlerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreAlertaRepository extends JpaRepository<PreAlerta,Long> {
    PreAlerta findByIdCourier(int id);
}
