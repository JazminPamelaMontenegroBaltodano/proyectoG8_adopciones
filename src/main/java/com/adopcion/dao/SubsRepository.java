package com.adopcion.dao;

import com.adopcion.domain.Subs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsRepository extends JpaRepository<Subs, Long> {
    
    
}
