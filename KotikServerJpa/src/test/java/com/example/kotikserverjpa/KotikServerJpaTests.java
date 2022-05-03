package com.example.kotikserverjpa;

import com.example.kotikserverjpa.entities.Kotik;
import com.example.kotikserverjpa.enumClass.Breed;
import com.example.kotikserverjpa.enumClass.Color;
import com.example.kotikserverjpa.repository.KotikRepository;
import com.example.kotikserverjpa.service.KotikService;
import com.example.kotikserverjpa.service.KotikServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class KotikServerJpaTests {

    @Autowired
    private KotikServiceImpl service;
    @Spy
    private KotikRepository kotikRepository;

    @Test
    public void checkKotikPresence() {
        Kotik cat = new Kotik("saske", LocalDate.of(2012, 12, 12), Breed.British, Color.Black);
        when(kotikRepository.save(cat)).thenReturn(new Kotik("saske", LocalDate.of(2012, 12, 12), Breed.British, Color.Black));
        Kotik savedKotik = service.findById(1);
        Assertions.assertEquals(cat.getId(), savedKotik.getId());
    }
}
