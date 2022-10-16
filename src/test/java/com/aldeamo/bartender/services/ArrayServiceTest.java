package com.aldeamo.bartender.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ArrayServiceTest {

    @Autowired
    ArrayService arrayService;

    @Test
    void test1() {
        assertEquals("Respuesta = [2, 4, 6, 8, 5, 7]", arrayService.pruebaAldeamo(1, 1L));
    }

    @Test
    void test2() {
        assertEquals("Respuesta = [2, 4, 6, 8, 5, 7]", arrayService.pruebaAldeamo(2, 1L));
    }

    @Test
    void test3() {
        assertEquals("Respuesta = [4, 2, 3, 7, 9, 5]", arrayService.pruebaAldeamo(1, 2L));
    }
}
