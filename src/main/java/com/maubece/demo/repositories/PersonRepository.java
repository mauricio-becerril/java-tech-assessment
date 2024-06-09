package com.maubece.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maubece.demo.models.PersonModel;

@Repository
public interface PersonRepository extends CrudRepository<PersonModel, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM Person WHERE name LIKE %:name%")
    public Optional<List<PersonModel>> findPersonsByName(@Param("name") String name);
}
