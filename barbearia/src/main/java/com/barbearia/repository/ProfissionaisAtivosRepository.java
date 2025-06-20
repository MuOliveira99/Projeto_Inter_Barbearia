package com.barbearia.repository;

import com.barbearia.model.ProfissionaisAtivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionaisAtivosRepository extends JpaRepository<ProfissionaisAtivos, Integer> {
}

