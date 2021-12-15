package com.example.currency.repository;

import com.example.currency.entity.Cube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@Component
public interface CubeRepository extends JpaRepository<Cube, Integer> {

    @Query(value = "SELECT id WHERE date = ?", nativeQuery = true)
    Optional<Integer> findByDate(LocalDate date);
}
