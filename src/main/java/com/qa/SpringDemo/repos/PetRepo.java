package com.qa.SpringDemo.repos;

import com.qa.SpringDemo.entities.Person;
import com.qa.SpringDemo.entities.Pet;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepo extends JpaRepository<Pet, Integer> {


    List<Pet> findByName(String name);

//    @Query("from Pet where owner_ID=:id")
//    List<Pet> findByOwner_ID(@Param("id") Integer id);


}
