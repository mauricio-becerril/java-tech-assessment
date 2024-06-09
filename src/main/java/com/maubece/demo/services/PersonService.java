package com.maubece.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maubece.demo.models.PersonModel;
import com.maubece.demo.repositories.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;
    
    public List<PersonModel> getPersons() {
        return (List<PersonModel>) repository.findAll();
    }

    public PersonModel getPersonById(Long id) {
        return repository.findById(id).get();
    }

    public List<PersonModel> getPersonsByName(String name) {
        return repository.findPersonsByName(name).get();
    }

    public PersonModel savePerson(PersonModel person) {
        return repository.save(person);
    }

    public PersonModel updatePerson(Long id, PersonModel person) throws Exception {
        if (getPersonById(id) == null) {
            throw new Exception("Person does not exist");
        } else {
            person.setId(id);
            return repository.save(person);
        }
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
