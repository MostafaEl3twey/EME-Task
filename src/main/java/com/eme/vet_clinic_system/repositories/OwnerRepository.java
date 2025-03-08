package com.eme.vet_clinic_system.repositories;


import com.eme.vet_clinic_system.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
