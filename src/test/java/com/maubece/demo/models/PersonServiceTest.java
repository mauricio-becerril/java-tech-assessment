package com.maubece.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.maubece.demo.repositories.PersonRepository;
import com.maubece.demo.services.PersonService;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @MockBean
    private PersonRepository repository;

    private PersonService personService;

    @Test
    public void test_getPersonById() {

        PersonModel mockModel = new PersonModel();
        mockModel.setId(1L);
        mockModel.setEmail("email@domain.com");
        mockModel.setName("Name");

        when(repository.findById(anyLong()).get()).thenReturn(mockModel);

        PersonModel model = personService.getPersonById(1L);
        assertNotNull(model);
        assertEquals(mockModel.getId(), model.getId());
        assertEquals(mockModel.getEmail(), model.getEmail());
        assertEquals(mockModel.getName(), model.getName());

    }
    
}
