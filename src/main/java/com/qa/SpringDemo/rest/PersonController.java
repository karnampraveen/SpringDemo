package com.qa.SpringDemo.rest;

import com.qa.SpringDemo.entities.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private List<Person> persons = new ArrayList<>();

    @GetMapping("/getAll")
    public List<Person> getall(){

        return persons;
    }

    @PostMapping("/create")
public Person createPerson(@RequestBody Person person){
        persons.add(person);
        return persons.get(persons.size()-1);
}

@DeleteMapping("/remove/{id}")
public Person removePerson(@PathVariable Integer id){
//        Person persontoremove = this.persons.get(id);
        return this.persons.remove(id.intValue());
}

@PatchMapping("/update/{id}")
public Person updatePerson(@PathVariable int id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) Integer age,
                           @RequestParam(required = false) String job){
        Person toUpate = this.persons.get(id);
        if(name != null) toUpate.setName(name);
        if(age != null) toUpate.setAge(age);
        if(job != null) toUpate.setJob(job);
        return toUpate ;
}

}
