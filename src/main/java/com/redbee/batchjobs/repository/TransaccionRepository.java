package com.redbee.batchjobs.repository;

import com.redbee.batchjobs.model.Transaccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

    Page<Transaccion> findByFechaCreacionBetween(
            Date fechaDesde, Date fechaHasta, Pageable pageable);

}
