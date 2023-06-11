package com.maubece.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maubece.demo.models.PersonModel;
import com.maubece.demo.repositories.PersonRepository;

@Service
public class PersonService {

    private PersonRepository repository;
    
    public List<PersonModel> getPersons() {
        return (List<PersonModel>) repository.findAll();
    }

    public PersonModel savePerson(PersonModel person) {
        return repository.save(person);
    }

    public boolean deletePerson(Long id) {
        boolean result = false;
        try {
            repository.deleteById(id);
            result = true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return result;
    }
}
