package com.eme.vet_clinic_system.servicies;

import com.eme.vet_clinic_system.entities.Clinic;
import com.eme.vet_clinic_system.entities.Doctor;
import com.eme.vet_clinic_system.entities.Owner;
import com.eme.vet_clinic_system.repositories.ClinicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;

    public Clinic createClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public List<Clinic> searchClinics(String phone, String address) {
        return clinicRepository.findByPhoneOrAddress(phone, address);
    }

    public Clinic getClinicById(Long id) {
        return clinicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Clinic not found with id: " + id));
    }

    public List<Doctor> getDoctorsByClinicId(Long clinicId) {
        if (clinicRepository.findById(clinicId).isPresent())
            return clinicRepository.findById(clinicId).get().getDoctors();

        return null;
    }
}
