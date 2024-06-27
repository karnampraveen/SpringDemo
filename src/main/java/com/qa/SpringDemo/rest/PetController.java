package com.qa.SpringDemo.rest;

import com.qa.SpringDemo.entities.Person;
import com.qa.SpringDemo.entities.Pet;
import com.qa.SpringDemo.services.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {
// No need of this list here as this is moved and will be managed by the PetService component
    //    private List<Pet> pets = new ArrayList<>();

private PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping("/pet/getAll")
    public List<Pet> getall(){
        return this.service.getall();
    }

    @GetMapping("/pet/getAllByOwner")
    public List<Pet> getallByOwner(@PathVariable Integer id){
        return this.service.getallByOwner(id);
    }

    @GetMapping("/pet/{id}")
    public ResponseEntity<?> pet(@PathVariable Integer id){
            return this.service.pet(id);
    }

    @GetMapping("/petByName/{name}")
    public ResponseEntity<?> petByName(@PathVariable String name){
        return this.service.petByName(name);
    }

// Extra stuff - finding record by non-key field
//    @GetMapping("/petAge/{age}")
//    public ResponseEntity<?> petByAge(@PathVariable Integer age){
//        return this.service.petByAge(age);
//    }

    @PostMapping("/pet/create")
public ResponseEntity<Pet> createPet(@RequestBody Pet pet){
        return this.service.createPet(pet);
}

@DeleteMapping("/pet/remove/{id}")
public Pet removePet(@PathVariable Integer id){
//        Pet pettoremove = this.pets.get(id);
        return this.service.removePet(id);
}

@PatchMapping("/pet/update/{id}")
public Pet updatePet(@PathVariable int id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) Integer age,
                           @RequestParam(required = false) String animalType,
                     @RequestParam(required = false) Person owner){
        return this.service.updatePet(id,name,age,animalType, owner) ;
}

}
