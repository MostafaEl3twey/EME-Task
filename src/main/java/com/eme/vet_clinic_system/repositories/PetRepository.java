package com.eme.vet_clinic_system.repositories;

import com.eme.vet_clinic_system.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
