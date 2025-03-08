package com.eme.vet_clinic_system.controllers;

import com.eme.vet_clinic_system.entities.Clinic;
import com.eme.vet_clinic_system.entities.Doctor;
import com.eme.vet_clinic_system.servicies.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinics")
public class ClinicController {
    @Autowired
    private ClinicService clinicService;

    @PostMapping
    public Clinic createClinic(@RequestBody Clinic clinic) {
        return clinicService.createClinic(clinic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable Long id) {
        Clinic clinic = clinicService.getClinicById(id); // Exception will be thrown if not found
        return ResponseEntity.ok(clinic);
    }

    @GetMapping("/search")
    public List<Clinic> searchClinics(@RequestParam String phone, @RequestParam String address) {
        return clinicService.searchClinics(phone, address);
    }

    @GetMapping("/{clinicId}/doctors")
    public List<Doctor> getDoctorsByClinicId(@PathVariable Long clinicId) {
        return clinicService.getDoctorsByClinicId(clinicId);
    }
}