package com.adopcion.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Subs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level;
    private LocalDate startDate;
    private String plan;
    private String status;


    public Subs() {
        
    }

    
    public Subs(String plan) {
        this.plan = plan;
        this.startDate = LocalDate.now();
        this.status = "Activo";
    }
}
