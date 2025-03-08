package com.eme.vet_clinic_system.servicies;

import com.eme.vet_clinic_system.entities.Owner;
import com.eme.vet_clinic_system.entities.Pet;
import com.eme.vet_clinic_system.repositories.OwnerRepository;
import com.eme.vet_clinic_system.repositories.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public Pet createPet(Pet pet) {
        Owner owner = ownerRepository.findById(pet.getOwner().getId()).orElseThrow(() -> new EntityNotFoundException("Owner not found"));
        pet.setOwner(owner);
        return petRepository.save(pet);
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found with id " + id));
    }

}
