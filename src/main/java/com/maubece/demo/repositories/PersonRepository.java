package com.maubece.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maubece.demo.models.PersonModel;

@Repository
public interface PersonRepository extends CrudRepository<PersonModel, Long> {}
