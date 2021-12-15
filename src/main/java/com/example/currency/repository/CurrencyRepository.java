package com.example.currency.repository;

import com.example.currency.entity.Cube;
import com.example.currency.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {


    @Query(value = "SELECT * FROM cube_currencies WHERE cube_id = ? ", nativeQuery = true)
    Optional<List<Currency>> findCurrencyByDate(Integer id);

}
