package com.example.kotikserverjpa;

import com.example.kotikserverjpa.entities.Kotik;
import com.example.kotikserverjpa.enumClass.Breed;
import com.example.kotikserverjpa.enumClass.Color;
import com.example.kotikserverjpa.repository.KotikRepository;
import com.example.kotikserverjpa.service.KotikService;
import com.example.kotikserverjpa.service.KotikServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


///@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class KotikServerJpaTests {

    @Mock
    private KotikRepository kotikRepository;

    @InjectMocks
    private KotikServiceImpl service;

    @Test
    public void checkKotikPresence() {
        Kotik cat = new Kotik("saske", LocalDate.of(2012, 12, 12), Breed.British, Color.Black);
//        doReturn(Optional.of(cat)).when(kotikRepository.findById(any()));
        when(kotikRepository.findById(any())).thenReturn(Optional.of(new Kotik("saske", LocalDate.of(2012, 12, 12), Breed.British, Color.Black)));
        Kotik savedKotik = service.findById(1);
        Assertions.assertEquals(cat.getId(), savedKotik.getId());
    }
}
