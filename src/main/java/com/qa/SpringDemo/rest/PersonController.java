package com.qa.SpringDemo.rest;

import com.qa.SpringDemo.entities.Person;
import com.qa.SpringDemo.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
// No need of this list here as this is moved and will be managed by the PersonService component
    //    private List<Person> persons = new ArrayList<>();

private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Person> getall(){
        return this.service.getall();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<?> person(@PathVariable Integer id){
            return this.service.person(id);
    }

// Extra stuff - finding record by non-key field
    @GetMapping("/personAge/{age}")
    public ResponseEntity<?> personByAge(@PathVariable Integer age){
        return this.service.personByAge(age);
    }

    @PostMapping("/create")
public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return this.service.createPerson(person);
}

@DeleteMapping("/remove/{id}")
public Person removePerson(@PathVariable Integer id){
//        Person persontoremove = this.persons.get(id);
        return this.service.removePerson(id);
}

@PatchMapping("/update/{id}")
public Person updatePerson(@PathVariable int id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) Integer age,
                           @RequestParam(required = false) String job){
        return this.service.updatePerson(id,name,age,job) ;
}

}
