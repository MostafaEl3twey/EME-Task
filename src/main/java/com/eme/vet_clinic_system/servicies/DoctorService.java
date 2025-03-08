package com.eme.vet_clinic_system.servicies;

import com.eme.vet_clinic_system.entities.Clinic;
import com.eme.vet_clinic_system.entities.Doctor;
import com.eme.vet_clinic_system.repositories.ClinicRepository;
import com.eme.vet_clinic_system.repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id " + id));
    }

    public boolean assignDoctorToClinic(Long doctorId, Long clinicId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Clinic clinic = clinicRepository.findById(clinicId)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        doctor.setClinic(clinic);
        doctorRepository.save(doctor);
        return true;
    }

    public void deAssignDoctorFromClinic(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctor.setClinic(null); // Remove the association
        doctorRepository.save(doctor);
    }
}