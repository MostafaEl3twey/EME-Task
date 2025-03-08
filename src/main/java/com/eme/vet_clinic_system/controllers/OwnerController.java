package com.eme.vet_clinic_system.controllers;

import com.eme.vet_clinic_system.entities.Owner;
import com.eme.vet_clinic_system.entities.Pet;
import com.eme.vet_clinic_system.servicies.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.createOwner(owner);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable Long id) {
        Owner owner = ownerService.getOwnerById(id);
        return ResponseEntity.ok(owner);
    }

    @GetMapping("/{id}/pets")
    public List<Pet> getPetsByOwnerId(@PathVariable Long id) {
        return ownerService.getPetsByOwnerId(id);
    }
}
