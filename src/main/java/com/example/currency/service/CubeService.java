package com.example.currency.service;

import com.example.currency.entity.Cube;
import com.example.currency.exceptions.NoEntityExceptions;
import com.example.currency.repository.CubeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CubeService {
    private final CubeRepository repository;


    public Integer findByDate(LocalDate date) {
        return repository.findByDate(date).orElseThrow(() -> new NoEntityExceptions(date.toString()));
    }

    public void saveCube(Cube cube) {
        Cube c = repository.save(cube);
    }
}
