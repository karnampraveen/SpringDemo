package com.qa.SpringDemo.services;

import com.qa.SpringDemo.entities.Person;
import com.qa.SpringDemo.entities.Pet;
import com.qa.SpringDemo.repos.PetRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

private PetRepo repo;

    public PetService(PetRepo repo) {
        this.repo = repo;
    }

    public List<Pet> getall(){

        return this.repo.findAll();
    }

    public List<Pet> getallByOwner(Integer id){

//        return this.repo.findByOwner_ID(id);
        return null;
    }

    public ResponseEntity<?> pet(Integer id){
        if(!this.repo.existsById(id))
            return new ResponseEntity<>("No pet found with ID : " + id,HttpStatus.NOT_FOUND);
        Pet found = this.repo.findById(id).get();
            return ResponseEntity.ok(found);
    }

    public ResponseEntity<?> petByName(String name){
        List<Pet> found = this.repo.findByName(name);
        return ResponseEntity.ok(found);
    }

//    public ResponseEntity<Pet> petByAge(Integer age){
//        Pet found = this.repo.findByAge(age);
//        return ResponseEntity.ok(found);
//    }

    public ResponseEntity<Pet> createPet( Pet pet){
        Pet created = this.repo.save(pet);
        return new ResponseEntity<>(created,HttpStatus.CREATED);
    }

    public Pet removePet( Integer id){
        Pet found = this.repo.findById(id).get();
        this.repo.deleteById(id);
        return found;
    }

    public Pet updatePet( int id,
                                String name,
                                Integer age,
                                String animalType,
                          Person owner){
        Pet toUpdate = this.repo.findById(id).get();
        if(name != null) toUpdate.setName(name);
        if(age != null) toUpdate.setAge(age);
        if(animalType != null) toUpdate.setAnimalType(animalType);
        if(owner != null) toUpdate.setOwner(owner);
        Pet updated = this.repo.save(toUpdate);
        return updated;
    }
}
