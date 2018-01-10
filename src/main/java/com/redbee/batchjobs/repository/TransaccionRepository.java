package com.redbee.batchjobs.repository;

import com.redbee.batchjobs.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

    List<Transaccion> findByFechaCreacionGreaterThanEqualAndFechaActualizacionLessThanEqual(
            Date fechaDesde, Date fechaHasta, Pageable pagable);

    List<Transaccion> findAllByAnioMoto(Long anioMoto);

}
