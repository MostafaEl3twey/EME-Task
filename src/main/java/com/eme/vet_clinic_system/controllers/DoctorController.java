package com.eme.vet_clinic_system.controllers;

import com.eme.vet_clinic_system.entities.Doctor;
import com.eme.vet_clinic_system.entities.Owner;
import com.eme.vet_clinic_system.servicies.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    @PutMapping("/{doctorId}/assign/{clinicId}")
    public String assignDoctorToClinic(@PathVariable Long doctorId, @PathVariable Long clinicId) {
        doctorService.assignDoctorToClinic(doctorId, clinicId);
        return "Doctor assigned to clinic successfully.";
    }

    @PutMapping("/{doctorId}/deassign")
    public String deAssignDoctorFromClinic(@PathVariable Long doctorId) {
        doctorService.deAssignDoctorFromClinic(doctorId);
        return "Doctor removed from clinic successfully.";
    }

}
