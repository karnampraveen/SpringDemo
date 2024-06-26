package com.qa.SpringDemo.services;

import com.qa.SpringDemo.entities.Person;
import com.qa.SpringDemo.repos.PersonRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

private PersonRepo repo;

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }

    public List<Person> getall(){

        return this.repo.findAll();
    }

    public ResponseEntity<?> person(Integer id){
        if(!this.repo.existsById(id))
            return new ResponseEntity<>("No person found with ID : " + id,HttpStatus.NOT_FOUND);
        Person found = this.repo.findById(id).get();
            return ResponseEntity.ok(found);
    }

    public ResponseEntity<Person> personByAge(Integer age){
        Person found = this.repo.findByAge(age);
        return ResponseEntity.ok(found);
    }

    public ResponseEntity<Person> createPerson( Person person){
        Person created = this.repo.save(person);
        return new ResponseEntity<>(created,HttpStatus.CREATED);
    }

    public Person removePerson( Integer id){
        Person found = this.repo.findById(id).get();
        this.repo.deleteById(id);
        return found;
    }

    public Person updatePerson( int id,
                                String name,
                                Integer age,
                                String job){
        Person toUpdate = this.repo.findById(id).get();
        if(name != null) toUpdate.setName(name);
        if(age != null) toUpdate.setAge(age);
        if(job != null) toUpdate.setJob(job);
        Person updated = this.repo.save(toUpdate);
        return updated;
    }
}
