package com.eme.vet_clinic_system.repositories;

import com.eme.vet_clinic_system.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
