package com.qa.SpringDemo.services;

import com.qa.SpringDemo.entities.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
public class PersonServiceOLD {

    private List<Person> persons = new ArrayList<>();

    public List<Person> getall(){

        return persons;
    }

    public ResponseEntity<?> person(Integer id){
        if(id == null || id < 0 || id >= persons.size())
            return new ResponseEntity<>("No person found with id " + id, HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.ok(this.persons.get(id));
    }

    public ResponseEntity<Person> createPerson( Person person){
        persons.add(person);
        Person added = persons.get(persons.size()-1);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }

    public Person removePerson( Integer id){
//        Person persontoremove = this.persons.get(id);
        return this.persons.remove(id.intValue());
    }

    public Person updatePerson( int id,
                                String name,
                                Integer age,
                                String job){
        Person toUpate = this.persons.get(id);
        if(name != null) toUpate.setName(name);
        if(age != null) toUpate.setAge(age);
        if(job != null) toUpate.setJob(job);
        return toUpate ;
    }
}
