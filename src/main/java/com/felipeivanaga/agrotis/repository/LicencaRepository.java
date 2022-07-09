package com.felipeivanaga.agrotis.repository;

import com.felipeivanaga.agrotis.entity.Licenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicencaRepository extends JpaRepository<Licenca, Long> {
}
