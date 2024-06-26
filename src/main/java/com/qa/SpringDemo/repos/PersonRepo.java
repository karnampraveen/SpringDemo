package com.qa.SpringDemo.repos;

import com.qa.SpringDemo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    Person findByAge(Integer age);
}
