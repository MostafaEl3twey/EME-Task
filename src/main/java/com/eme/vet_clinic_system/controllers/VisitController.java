package com.eme.vet_clinic_system.controllers;

import com.eme.vet_clinic_system.entities.Visit;
import com.eme.vet_clinic_system.servicies.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/visits")
public class VisitController {
    @Autowired
    private VisitService visitService;

    @PostMapping
    public Visit createVisit(@RequestBody Visit visit) {
        return visitService.createVisit(visit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visit> getVisit(@PathVariable Long id) {
        Visit visit = visitService.getVisitById(id);
        return ResponseEntity.ok(visit);
    }
}
