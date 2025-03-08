package com.eme.vet_clinic_system.repositories;

import com.eme.vet_clinic_system.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
