package com.cenfotec.localogistica.repository;

import com.cenfotec.localogistica.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
