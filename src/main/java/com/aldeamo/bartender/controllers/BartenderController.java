package com.aldeamo.bartender.controllers;

import com.aldeamo.bartender.models.entity.Array;
import com.aldeamo.bartender.services.ArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BartenderController {

    @Autowired
    private ArrayService arrayService;

    @GetMapping("/{Q}/{id}")
    public ResponseEntity<?> apiParameter(@PathVariable int Q, @PathVariable Long id) {
        String response = arrayService.pruebaAldeamo(Q, id);
        return ResponseEntity.ok(response);
    }

}
