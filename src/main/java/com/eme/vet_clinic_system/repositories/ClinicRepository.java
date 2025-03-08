package com.eme.vet_clinic_system.repositories;

import com.eme.vet_clinic_system.entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    List<Clinic> findByPhoneOrAddress(String phone, String address);
}
