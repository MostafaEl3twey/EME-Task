package com.eme.vet_clinic_system.servicies;

import com.eme.vet_clinic_system.entities.*;
import com.eme.vet_clinic_system.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private PetRepository petRepository;

    public Visit createVisit(Visit visit) {
        Doctor doctor = doctorRepository.findById(visit.getDoctor().getId()).orElseThrow(() -> new RuntimeException("Doctor not found"));
        visit.setDoctor(doctor);

        Clinic clinic = clinicRepository.findById(visit.getClinic().getId()).orElseThrow(() -> new RuntimeException("Clinic not found"));
        visit.setClinic(clinic);

        Pet pet = petRepository.findById(visit.getPet().getId()).orElseThrow(() -> new RuntimeException("Pet not found"));
        visit.setPet(pet);

        return visitRepository.save(visit);
    }

    public Visit getVisitById(Long id) {
        return visitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Visit not found with id: " + id));
    }
}
