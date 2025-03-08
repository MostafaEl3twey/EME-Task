package com.eme.vet_clinic_system.servicies;

import com.eme.vet_clinic_system.entities.Owner;
import com.eme.vet_clinic_system.entities.Pet;
import com.eme.vet_clinic_system.repositories.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Owner not found with id: " + id));
    }

    public List<Pet> getPetsByOwnerId(Long ownerId) {
        return ownerRepository.findById(ownerId).get().getPets();
    }

}
